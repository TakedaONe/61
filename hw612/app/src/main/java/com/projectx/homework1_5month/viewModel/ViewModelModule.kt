package com.projectx.homework1_5month.viewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import com.projectx.homework1_5month.viewModel.FragmentViewModel
import com.projectx.homework1_5month.viewModel.SecondViewModel

val viewModelModule = module {
    viewModel { FragmentViewModel(get()) }
    viewModel { SecondViewModel(get()) }
}
