package com.blannon_network.countyrevenue.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import kotlinx.coroutines.flow.*

class CessPoints : Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    override fun Content() {
        val viewModel = viewModel<MainViewModel>()
        val searchText by viewModel.searchText.collectAsState()
        val cessPoints by viewModel.cessPoints.collectAsState()
        val isSearching by viewModel.isSearching.collectAsState()
        val navigator = LocalNavigator.current

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .height(75.dp),
                value = searchText,
                onValueChange = viewModel::onSearchTextChange,
                label = { Text("Search") },
                placeholder = { Text("Search cess points...") },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            if (isSearching) {
                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                items(cessPoints) { cessPoint ->
                    CessPointCard(cessPoint)
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CessPointCard(cessPoint: CessPoint) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        onClick = {  }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = cessPoint.cessName,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF1E1E1E)
                )

            }
        }
    }
}

class MainViewModel : ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _cessPoints = MutableStateFlow(allCessPoints)
    val cessPoints = searchText
        .combine(_cessPoints) { text, points ->
            _isSearching.value = true
            val result = if (text.isBlank()) {
                points
            } else {
                points.filter { it.matchesSearchQuery(text) }
            }
            _isSearching.value = false
            result
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            allCessPoints
        )

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }
}

data class CessPoint(
    val cessName: String
) {
    fun matchesSearchQuery(query: String): Boolean {
        val matchCombinations = listOf(
            cessName,
            "${cessName.first()}",
            "${cessName.last()}"
        )
        return matchCombinations.any {
            it.contains(query, ignoreCase = true)
        }
    }
}

private val allCessPoints = listOf(
    CessPoint("Isinya RoadBlock"),
    CessPoint("Saris RoadBlock"),
    CessPoint("Kitengela A RoadBlock"),
    CessPoint("Kitengela B RoadBlock"),
    CessPoint("NKURUKA ROADBLOCK"),
    CessPoint("KONZA ROADBLOCK"),
    CessPoint("IMARORO ROADBLOCK"),
    CessPoint("KIBINI ROADBLOCK"),
    CessPoint("SHOLINKE ROADBLOCK"),
    CessPoint("EMALI ROADBLOCK"),
    CessPoint("NAMANGA ROADBLOCK"),
    CessPoint("ISAJILONI ROADBLOCK"),
    CessPoint("TATA ROADBLOCK"),
    CessPoint("KMQ ROADBLOCK"),
    CessPoint("KISERIAN ROADBLOCK"),
    CessPoint("ERETETI ROADBLOCK"),
    CessPoint("OLOOLOITIKOSHI ROADBLOCK")
)