package com.swapi.app.presentation.starships

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapi.app.domain.model.Starship
import com.swapi.app.presentation.common.UiState
import com.swapi.app.presentation.ui.components.DetailRow
import com.swapi.app.presentation.ui.components.EmptyState
import com.swapi.app.presentation.ui.components.ErrorState
import com.swapi.app.presentation.ui.components.LoadingIndicator

@Composable
fun StarshipDetailScreen(viewModel: StarshipDetailViewModel = hiltViewModel()) {
    when (val s = viewModel.state.collectAsState().value) {
        is UiState.Loading -> LoadingIndicator()
        is UiState.Empty -> EmptyState("Starship not found")
        is UiState.Error -> ErrorState(s.message)
        is UiState.Success -> StarshipDetailContent(s.data)
    }
}

@Composable
private fun StarshipDetailContent(ship: Starship) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(ship.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(4.dp))
        Text(ship.model, style = MaterialTheme.typography.bodyLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                DetailRow("Class", ship.starshipClass)
                DetailRow("Manufacturer", ship.manufacturer)
                DetailRow("Crew", ship.crew)
                DetailRow("Passengers", ship.passengers)
                DetailRow("Max Speed", ship.maxAtmospheringSpeed)
                DetailRow("Hyperdrive Rating", ship.hyperdriveRating)
            }
        }
    }
}
