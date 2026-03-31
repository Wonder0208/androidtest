package com.swapi.app.presentation.planets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Public
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapi.app.domain.model.Planet
import com.swapi.app.presentation.common.UiState
import com.swapi.app.presentation.ui.components.EmptyState
import com.swapi.app.presentation.ui.components.ErrorState
import com.swapi.app.presentation.ui.components.LoadingIndicator

@Composable
fun PlanetsScreen(
    onPlanetClick: (Int) -> Unit,
    viewModel: PlanetsViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    when (val s = state) {
        is UiState.Loading -> LoadingIndicator()
        is UiState.Empty -> EmptyState("No planets found")
        is UiState.Error -> ErrorState(s.message)
        is UiState.Success -> LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(s.data, key = { it.id }) { planet ->
                PlanetCard(planet, onClick = { onPlanetClick(planet.id) })
            }
        }
    }
}

@Composable
private fun PlanetCard(planet: Planet, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(
                imageVector = Icons.Default.Public,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(40.dp)
            )
            Spacer(Modifier.width(16.dp))
            Column {
                Text(text = planet.name, style = MaterialTheme.typography.titleMedium)
                Text(
                    text = "Climate: ${planet.climate} · Terrain: ${planet.terrain}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Population: ${planet.population}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}
