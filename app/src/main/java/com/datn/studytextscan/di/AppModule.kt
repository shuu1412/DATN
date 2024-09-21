package com.datn.studytextscan.di

import android.content.Context
import androidx.room.Room
import com.datn.studytextscan.datastore.AppPreferences
import com.datn.studytextscan.datastore.datastore
import com.datn.studytextscan.persistence.database.ApplicationDatabase

import com.datn.studytextscan.service.entityextraction.EntityExtractionUseCase
import com.datn.studytextscan.service.pdfExport.PdfExportServiceImpl
import com.datn.studytextscan.service.textFilter.TextFilterService
import com.datn.studytextscan.service.textFilter.TextFilterServiceImpl
import com.datn.studytextscan.service.textextract.ScanTextFromImageUseCase
import com.google.android.play.core.review.ReviewManager
import com.google.android.play.core.review.ReviewManagerFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.bind
import org.koin.dsl.module

private fun provideDatabase(context: Context) =
    Room.databaseBuilder(
        context,
        ApplicationDatabase::class.java,
        "posts_database"
    ).fallbackToDestructiveMigration().build()

private fun providePdfExportService() =
    PdfExportServiceImpl()

private fun providePreferences(context: Context) = AppPreferences(context.datastore)

private fun provideFilterTextService() =
    TextFilterServiceImpl()

private fun provideScanTextFromImageUseCase() =
    ScanTextFromImageUseCase()


private fun provideReviewManager(context: Context): ReviewManager =
    ReviewManagerFactory.create(context)

private fun provideEntityExtractionUseCase(): EntityExtractionUseCase =
    EntityExtractionUseCase()

val appModule = module {
    single { provideDatabase(context = androidContext()) }
    single { providePdfExportService() }
    factory { providePreferences(androidContext()) }
    single { provideFilterTextService() } bind TextFilterService::class
    factory { provideEntityExtractionUseCase() }
    factory { provideScanTextFromImageUseCase() }
    single { provideReviewManager(androidContext()) }
}