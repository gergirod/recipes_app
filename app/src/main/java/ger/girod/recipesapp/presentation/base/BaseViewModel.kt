package ger.girod.recipesapp.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ger.girod.recipesapp.presentation.utils.ScreenState

abstract class BaseViewModel : ViewModel() {

    var errorMessageData : MutableLiveData<String> = MutableLiveData()
    var screenSteteData : MutableLiveData<ScreenState> = MutableLiveData()

}