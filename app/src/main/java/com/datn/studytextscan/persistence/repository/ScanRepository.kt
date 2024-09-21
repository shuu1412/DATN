package com.datn.studytextscan.persistence.repository

import com.datn.studytextscan.persistence.database.ApplicationDatabase
import com.datn.studytextscan.persistence.entity.Scan

class ScanRepository(
    database: ApplicationDatabase
) {
    private val dao = database.scanDao

    val allScans = dao.getAllScans()
    val allPinnedScans = dao.getAllPinnedScans()

    suspend fun insertScan(scan: Scan) = dao.insertScan(scan)
    suspend fun deleteScan(scan: Scan) = dao.deleteScan(scan)
    suspend fun updateScan(scan: Scan) = dao.updateScan(scan)

    fun getScanById(id: Int) = dao.getScanById(id)
}