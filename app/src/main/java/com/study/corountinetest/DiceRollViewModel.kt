package com.study.corountinetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DiceRollViewModel: ViewModel() {
    fun doSome(){
        viewModelScope.launch {

        }
    }
}