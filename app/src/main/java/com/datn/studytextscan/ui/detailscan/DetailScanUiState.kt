package com.datn.studytextscan.ui.detailscan

import com.datn.studytextscan.persistence.entity.ExtractionModel
import com.datn.studytextscan.persistence.entity.Scan

data class DetailScanUiState(
    val scan: Scan? = null,
    val filteredTextModels: List<ExtractionModel> = emptyList(),
    val isLoading: Boolean = true,
    val isCreated: Int = 0
)
