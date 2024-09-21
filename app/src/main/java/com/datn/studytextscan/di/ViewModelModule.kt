package com.datn.studytextscan.di

import com.datn.studytextscan.ui.detailscan.DetailScanViewModel
import com.datn.studytextscan.ui.home.HomeViewModel
import com.datn.studytextscan.ui.pdfDialog.PdfDialogViewModel
import com.datn.studytextscan.ui.support.SupportViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            scanRepo = get(),
            filteredTextModelRepo = get(),
            prefs = get(),
            scanTextFromImageUseCase = get(),
            entityExtractionUseCase = get()
        )
    }

    viewModel {
        DetailScanViewModel(
            savedStateHandle = get(),
            scanRepository = get(),
            filteredModelsRepository = get()
        )
    }
    viewModel {
        PdfDialogViewModel(savedStateHandle = get(), scanRepo = get())
    }
    viewModelOf(::SupportViewModel)
}