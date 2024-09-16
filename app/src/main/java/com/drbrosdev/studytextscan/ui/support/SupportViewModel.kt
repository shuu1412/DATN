package com.drbrosdev.studytextscan.ui.support

import androidx.lifecycle.ViewModel
import com.drbrosdev.studytextscan.datastore.AppPreferences
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

class SupportViewModel(
    private val preferences: AppPreferences
) : ViewModel() {
    private val _events = Channel<SupportEvents>()
    val events = _events.receiveAsFlow()


}