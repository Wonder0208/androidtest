package com.swapi.app.presentation.planets

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Planet
import com.swapi.app.domain.usecase.GetPlanetsUseCase
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel @Inject constructor(
    private val getPlanetsUseCase: GetPlanetsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Planet>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Planet>>> = _state

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val result = getPlanetsUseCase()
                _state.value = if (result.isEmpty()) UiState.Empty else UiState.Success(result)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
