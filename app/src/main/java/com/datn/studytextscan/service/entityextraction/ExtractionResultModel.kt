package com.datn.studytextscan.service.entityextraction

import com.datn.studytextscan.persistence.entity.ExtractionModelType

data class ExtractionResultModel(
    val type: ExtractionModelType,
    val content: String
)
