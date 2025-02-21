package be.hcpl.android.sportapp

import be.hcpl.android.sportapp.ui.view.LiveDataViewModel
import be.hcpl.android.sportapp.ui.view.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::MainViewModel)
    viewModelOf(::LiveDataViewModel)
}