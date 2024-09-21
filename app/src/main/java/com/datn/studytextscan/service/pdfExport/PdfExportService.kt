package com.datn.studytextscan.service.pdfExport

import android.content.Context
import com.datn.studytextscan.persistence.entity.Scan

interface PdfExportService {

    fun printDocument(
        context: Context,
        titleOfDocument: String,
        scans: List<Scan>,
        color: Int,
        fontSize: Int
    )
}