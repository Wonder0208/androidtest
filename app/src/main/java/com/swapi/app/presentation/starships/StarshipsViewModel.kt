package com.swapi.app.presentation.starships

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Starship
import com.swapi.app.domain.usecase.GetStarshipsUseCase
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StarshipsViewModel @Inject constructor(
    private val getStarshipsUseCase: GetStarshipsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Starship>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Starship>>> = _state

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val result = getStarshipsUseCase()
                _state.value = if (result.isEmpty()) UiState.Empty else UiState.Success(result)
            } catch (e: Exception) {
                _state.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}
