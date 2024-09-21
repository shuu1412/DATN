package com.datn.studytextscan.ui.support

sealed interface SupportEvents {
    object SupportGiven: SupportEvents
    data class ErrorOccured(val message: String, val debugMessage: String): SupportEvents
}