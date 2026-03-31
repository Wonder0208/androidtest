package com.swapi.app.presentation.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.swapi.app.domain.model.Person
import com.swapi.app.domain.usecase.GetPeopleUseCase
import com.swapi.app.presentation.common.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PeopleViewModel @Inject constructor(
    private val getPeopleUseCase: GetPeopleUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Person>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Person>>> = _state

    private val allPeople = mutableListOf<Person>()
    private var currentPage = 1
    var hasMore = true
        private set

    init {
        loadPeople()
    }

    fun loadPeople() {
        if (_state.value is UiState.Loading && allPeople.isNotEmpty()) return
        viewModelScope.launch {
            _state.value = UiState.Loading
            try {
                val result = getPeopleUseCase(currentPage)
                if (result.isEmpty() && allPeople.isEmpty()) {
                    _state.value = UiState.Empty
                } else {
                    allPeople.addAll(result)
                    hasMore = result.size == 10
                    _state.value = UiState.Success(allPeople.toList())
                }
            } catch (e: Exception) {
                _state.value = if (allPeople.isEmpty()) UiState.Error(e.message ?: "Unknown error")
                else UiState.Success(allPeople.toList())
            }
        }
    }

    fun loadNextPage() {
        if (!hasMore) return
        currentPage++
        viewModelScope.launch {
            try {
                val result = getPeopleUseCase(currentPage)
                hasMore = result.size == 10
                allPeople.addAll(result)
                _state.value = UiState.Success(allPeople.toList())
            } catch (e: Exception) {
                // keep current list on pagination error
            }
        }
    }
}
