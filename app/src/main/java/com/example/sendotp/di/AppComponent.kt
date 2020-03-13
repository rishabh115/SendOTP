package com.example.sendotp.di

import android.app.Application
import android.content.Context
import com.example.sendotp.ui.details.DetailsComponent
import com.example.sendotp.ui.home.HomeActivity
import com.example.sendotp.ui.home.HomeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ApiModule::class,
    SubComponentsModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun homeComponent():HomeComponent.Factory

    fun detailsComponent():DetailsComponent.Factory
}