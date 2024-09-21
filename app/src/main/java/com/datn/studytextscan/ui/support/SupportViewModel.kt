package com.datn.studytextscan.ui.support

import androidx.lifecycle.ViewModel
import com.datn.studytextscan.datastore.AppPreferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class SupportViewModel(
    private val preferences: AppPreferences
) : ViewModel() {
    private val _events = Channel<SupportEvents>()
    val events = _events.receiveAsFlow()


}