package com.datn.studytextscan.ui.home.reward

import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.datn.studytextscan.databinding.FragmentScanHomeBinding
import com.datn.studytextscan.ui.support.theme.ScannerateTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

fun FragmentScanHomeBinding.setupComposeSnackbar(
    rewardCount: Flow<Boolean>,
    onRewardShown: () -> Unit
) {
    composeViewSnackBar.apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
        setContent {
            ScannerateTheme {
                val snackbarHostState = remember { SnackbarHostState() }

                LaunchedEffect(Unit) {
                    rewardCount.collect {
                        delay(1000)
                        if (it) {
                            snackbarHostState.showSnackbar("")
                            onRewardShown()
                        }
                    }
                }
                RewardToast(snackbarHostState = snackbarHostState)
            }
        }
    }
}
