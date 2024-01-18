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
import com.example.immagic.homepage.Play.PlayQuoteImp
import com.example.immagic.homepage.Play.PlayQuoteRepository
import com.example.immagic.homepage.Play.PlayQuoteViewModel
import com.example.immagic.nawigation.categories.category.categoryselection.CategorySelectionImp
import com.example.immagic.nawigation.categories.category.categoryselection.CategorySelectionRepository
import com.example.immagic.nawigation.categories.category.categoryselection.CategorySelectionViemModel


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

    single<CategorySelectionRepository> {CategorySelectionImp(androidContext())}
    viewModel { CategorySelectionViemModel(get()) }

    single<PlayQuoteRepository> { PlayQuoteImp(androidContext()) }
    viewModel { (cardSetId: Int) -> PlayQuoteViewModel(get(), cardSetId) }
}












