package com.ems.codingtestarshad.fragments.allUsers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ems.codingtestarshad.api.RetrofitClient
import com.ems.codingtestarshad.api.models.HomeResponseItem
import com.ems.codingtestarshad.baseClass.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    var usersData: MutableLiveData<List<HomeResponseItem>> = MutableLiveData()

    init {

    }

    fun getUserData(){
        viewModelScope.launch {
            usersData.value = RetrofitClient.apiService.getUserData()
        }
    }
}