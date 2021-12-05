package com.ems.codingtestarshad.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "userTable")
@Parcelize
data class UsersData(
    val name: String? = null,
    val image: String? = null,
    val company: String? = null,
    @PrimaryKey val email: String,
    val website: String? = null,
): Parcelable
