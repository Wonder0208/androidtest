package com.swapi.app.presentation.people

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.swapi.app.domain.model.Person
import com.swapi.app.presentation.common.UiState
import com.swapi.app.presentation.ui.components.DetailRow
import com.swapi.app.presentation.ui.components.EmptyState
import com.swapi.app.presentation.ui.components.ErrorState
import com.swapi.app.presentation.ui.components.LoadingIndicator

@Composable
fun PersonDetailScreen(viewModel: PersonDetailViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()

    when (val s = state) {
        is UiState.Loading -> LoadingIndicator()
        is UiState.Empty -> EmptyState("Character not found")
        is UiState.Error -> ErrorState(s.message)
        is UiState.Success -> PersonDetailContent(s.data)
    }
}

@Composable
private fun PersonDetailContent(person: Person) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(text = person.name, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        Card(modifier = Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                DetailRow("Birth Year", person.birthYear)
                DetailRow("Gender", person.gender)
                DetailRow("Height", "${person.height} cm")
                DetailRow("Mass", "${person.mass} kg")
                DetailRow("Hair Color", person.hairColor)
                DetailRow("Skin Color", person.skinColor)
                DetailRow("Eye Color", person.eyeColor)
                DetailRow("Films", "${person.films.size} appearances")
            }
        }
    }
}
