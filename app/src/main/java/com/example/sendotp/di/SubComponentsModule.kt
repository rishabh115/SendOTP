package com.example.sendotp.di

import com.example.sendotp.ui.details.DetailsComponent
import com.example.sendotp.ui.home.HomeComponent
import dagger.Module

@Module(subcomponents = [HomeComponent::class, DetailsComponent::class])
class SubComponentsModule