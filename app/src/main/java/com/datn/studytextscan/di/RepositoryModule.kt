package com.datn.studytextscan.di

import com.datn.studytextscan.persistence.repository.FilteredTextRepository
import com.datn.studytextscan.persistence.repository.ScanRepository
import org.koin.dsl.module

val repoModule = module {
    single { ScanRepository(database = get()) }
    single { FilteredTextRepository(database = get()) }
}