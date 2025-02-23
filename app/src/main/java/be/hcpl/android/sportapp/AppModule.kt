package be.hcpl.android.sportapp

import be.hcpl.android.sportapp.domain.storage.LocalStorage
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.view.InfoViewModel
import be.hcpl.android.sportapp.ui.view.MainViewModel
import be.hcpl.android.sportapp.ui.view.MaxRateViewModel
import be.hcpl.android.sportapp.ui.view.ZonesViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::MainViewModel)
    viewModelOf(::InfoViewModel)
    viewModelOf(::MaxRateViewModel)
    viewModelOf(::ZonesViewModel)

    factoryOf(::Literals)
    factoryOf(::LocalStorage)
}