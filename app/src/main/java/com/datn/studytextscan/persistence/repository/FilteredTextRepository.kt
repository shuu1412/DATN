package com.datn.studytextscan.persistence.repository

import com.datn.studytextscan.persistence.database.ApplicationDatabase
import com.datn.studytextscan.persistence.entity.FilteredTextModel

class FilteredTextRepository(
    database: ApplicationDatabase
) {
    private val dao = database.filteredTextModelDao

    fun getAllModels() = dao.getAllModels()

    fun getModelsByScanId(scanId: Int) = dao.getModelsByScanId(scanId)

    suspend fun insertModel(model: FilteredTextModel) = dao.insertModel(model)
}