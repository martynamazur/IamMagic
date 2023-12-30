package com.example.immagic

import android.app.Application
import com.example.immagic.nawigation.myprofile.profile.MyProfileImp
import com.example.immagic.nawigation.myprofile.profile.MyProfileRepository
import com.example.immagic.nawigation.myprofile.profile.MyProfileViewModel

import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import com.example.immagic.homepage.HomePageViewModel




class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(appModule)
            //modules(coroutineModule)
        }
    }
}

val appModule = module {
    single<MyProfileRepository> { MyProfileImp(androidContext()) }
    viewModel { MyProfileViewModel(get()) }

    // Add the following line to include the module for HomePageViewModel
    viewModel { HomePageViewModel(get()) }
}







