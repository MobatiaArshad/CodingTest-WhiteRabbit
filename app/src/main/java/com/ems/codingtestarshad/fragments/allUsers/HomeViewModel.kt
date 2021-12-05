package com.ems.codingtestarshad.fragments.allUsers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ems.codingtestarshad.api.RetrofitClient
import com.ems.codingtestarshad.api.models.HomeResponseItem
import com.ems.codingtestarshad.baseClass.AppApplication
import com.ems.codingtestarshad.baseClass.BaseViewModel
import com.ems.codingtestarshad.db.UsersData
import com.ems.codingtestarshad.db.userDataBase
import com.ems.codingtestarshad.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel() {

    var usersData: MutableLiveData<List<HomeResponseItem>> = MutableLiveData()
    var databaseData: MutableLiveData<ArrayList<UsersData>> = MutableLiveData()
    val onDataUploaded = SingleLiveEvent<Unit>()


    fun getUserData() {
        viewModelScope.launch {

            usersData.value = RetrofitClient.apiService.getUserData()

            usersData.value!!.forEach {

                userDataBase.getDatabase(AppApplication.instance).userDao().insert(
                    UsersData(
                        it.name!!,
                        it.profileImage,
                        it.company?.name,
                        it.email!!,
                        it.website
                    )
                )

            }

            onDataUploaded.call()
        }
    }

    fun getOfflineData(){
        onDataUploaded.call()
    }

}