package be.hcpl.android.qwik

import be.hcpl.android.qwik.domain.repository.LocalProgramRepository
import be.hcpl.android.qwik.domain.storage.LocalStorage
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.view.InfoViewModel
import be.hcpl.android.qwik.ui.view.MainViewModel
import be.hcpl.android.qwik.ui.view.MaxRateViewModel
import be.hcpl.android.qwik.ui.view.TrainingViewModel
import be.hcpl.android.qwik.ui.view.ZonesViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::MainViewModel)
    viewModelOf(::InfoViewModel)
    viewModelOf(::MaxRateViewModel)
    viewModelOf(::ZonesViewModel)
    viewModelOf(::TrainingViewModel)

    factoryOf(::Literals)
    factoryOf(::LocalStorage)
    factoryOf(::LocalProgramRepository)
}