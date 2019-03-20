package com.example.data.store

import android.provider.ContactsContract
import com.example.domain.model.Profile
import io.reactivex.Single

interface ProfileDataStore {
    fun getProfiles(): Single<List<Profile>>
}