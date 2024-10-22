package com.projectx.homework1_5month.network

import org.koin.dsl.module
import com.projectx.homework1_5month.network.Reprository
import com.projectx.homework1_5month.network.Reprository2

val repositoryModule = module {
    single { Reprository(get()) }
    single { Reprository2(get()) }
}
