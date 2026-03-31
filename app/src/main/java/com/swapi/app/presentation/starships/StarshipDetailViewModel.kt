package com.swapi.app.presentation.starships

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Starship
import com.swapi.app.domain.repository.StarshipRepository
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarshipDetailViewModel @Inject constructor(
    private val repository: StarshipRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val starshipId: Int = checkNotNull(savedStateHandle["starshipId"])

    private val _state = MutableStateFlow<UiState<Starship>>(UiState.Loading)
    val state: StateFlow<UiState<Starship>> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState.Loading
            val ship = repository.getStarshipById(starshipId)
            _state.value = if (ship != null) UiState.Success(ship) else UiState.Empty
        }
    }
}
