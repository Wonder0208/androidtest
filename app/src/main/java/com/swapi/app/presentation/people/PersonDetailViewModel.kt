package com.swapi.app.presentation.people

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Person
import com.swapi.app.domain.usecase.GetPersonDetailUseCase
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor(
    private val getPersonDetailUseCase: GetPersonDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val personId: Int = checkNotNull(savedStateHandle["personId"])

    private val _state = MutableStateFlow<UiState<Person>>(UiState.Loading)
    val state: StateFlow<UiState<Person>> = _state

    init {
        loadPerson()
    }

    private fun loadPerson() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            val person = getPersonDetailUseCase(personId)
            _state.value = if (person != null) UiState.Success(person) else UiState.Empty
        }
    }
}
