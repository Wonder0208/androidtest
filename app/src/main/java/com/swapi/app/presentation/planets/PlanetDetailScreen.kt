package com.swapi.app.presentation.planets

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapi.app.domain.model.Planet
import com.swapi.app.presentation.common.UiState
import com.swapi.app.presentation.ui.components.DetailRow
import com.swapi.app.presentation.ui.components.EmptyState
import com.swapi.app.presentation.ui.components.ErrorState
import com.swapi.app.presentation.ui.components.LoadingIndicator

@Composable
fun PlanetDetailScreen(viewModel: PlanetDetailViewModel = hiltViewModel()) {
    when (val s = viewModel.state.collectAsState().value) {
        is UiState.Loading -> LoadingIndicator()
        is UiState.Empty -> EmptyState("Planet not found")
        is UiState.Error -> ErrorState(s.message)
        is UiState.Success -> PlanetDetailContent(s.data)
    }
}

@Composable
private fun PlanetDetailContent(planet: Planet) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(planet.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                DetailRow("Climate", planet.climate)
                DetailRow("Terrain", planet.terrain)
                DetailRow("Population", planet.population)
                DetailRow("Diameter", "${planet.diameter} km")
                DetailRow("Gravity", planet.gravity)
                DetailRow("Orbital Period", "${planet.orbitalPeriod} days")
                DetailRow("Rotation Period", "${planet.rotationPeriod} hours")
            }
        }
    }
}
