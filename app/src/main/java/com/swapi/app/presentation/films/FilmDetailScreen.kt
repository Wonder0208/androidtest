package com.swapi.app.presentation.films

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapi.app.domain.model.Film
import com.swapi.app.presentation.common.UiState
import com.swapi.app.presentation.ui.components.DetailRow
import com.swapi.app.presentation.ui.components.EmptyState
import com.swapi.app.presentation.ui.components.ErrorState
import com.swapi.app.presentation.ui.components.LoadingIndicator

@Composable
fun FilmDetailScreen(viewModel: FilmDetailViewModel = hiltViewModel()) {
    when (val s = viewModel.state.collectAsState().value) {
        is UiState.Loading -> LoadingIndicator()
        is UiState.Empty -> EmptyState("Film not found")
        is UiState.Error -> ErrorState(s.message)
        is UiState.Success -> FilmDetailContent(s.data)
    }
}

@Composable
private fun FilmDetailContent(film: Film) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Episode ${film.episodeId}", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
        Spacer(Modifier.height(4.dp))
        Text(film.title, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                DetailRow("Director", film.director)
                DetailRow("Producer", film.producer)
                DetailRow("Release Date", film.releaseDate)
            }
        }
        Spacer(Modifier.height(16.dp))
        Text("Opening Crawl", style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(8.dp))
        Card(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = film.openingCrawl,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
