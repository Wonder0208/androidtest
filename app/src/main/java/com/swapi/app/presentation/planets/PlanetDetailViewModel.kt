package com.swapi.app.presentation.planets

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Planet
import com.swapi.app.domain.repository.PlanetRepository
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetDetailViewModel @Inject constructor(
    private val repository: PlanetRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val planetId: Int = checkNotNull(savedStateHandle["planetId"])

    private val _state = MutableStateFlow<UiState<Planet>>(UiState.Loading)
    val state: StateFlow<UiState<Planet>> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState.Loading
            val planet = repository.getPlanetById(planetId)
            _state.value = if (planet != null) UiState.Success(planet) else UiState.Empty
        }
    }
}
