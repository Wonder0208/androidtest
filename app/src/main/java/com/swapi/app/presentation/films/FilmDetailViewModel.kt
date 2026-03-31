package com.swapi.app.presentation.films

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Film
import com.swapi.app.domain.repository.FilmRepository
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmDetailViewModel @Inject constructor(
    private val repository: FilmRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val filmId: Int = checkNotNull(savedStateHandle["filmId"])

    private val _state = MutableStateFlow<UiState<Film>>(UiState.Loading)
    val state: StateFlow<UiState<Film>> = _state

    init {
        viewModelScope.launch {
            _state.value = UiState.Loading
            val film = repository.getFilmById(filmId)
            _state.value = if (film != null) UiState.Success(film) else UiState.Empty
        }
    }
}
