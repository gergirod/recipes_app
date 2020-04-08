package ger.girod.recipesapp.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    lateinit var errorMessageData : MutableLiveData<String>

}