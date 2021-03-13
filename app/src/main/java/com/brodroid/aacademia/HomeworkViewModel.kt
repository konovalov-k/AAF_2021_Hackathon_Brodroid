package com.brodroid.aacademia

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeworkViewModel : ViewModel() {

    private var _onReadyToShow = MutableLiveData<Unit>()
    private var _onEmptyUrl = MutableLiveData<Unit>()
    val onReadyToShow: LiveData<Unit> = _onReadyToShow
    var onEmptyUrl: LiveData<Unit> = _onEmptyUrl

    fun checkWhatSHowToUser(homeworkUrl: String) {
        if (homeworkUrl.isEmpty()) {
            _onEmptyUrl.value = Unit
        } else {
            _onReadyToShow.value = Unit
        }
    }
}