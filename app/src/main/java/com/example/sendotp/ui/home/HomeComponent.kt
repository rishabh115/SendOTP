package com.example.sendotp.ui.home

import dagger.Subcomponent

@Subcomponent
interface HomeComponent {

   @Subcomponent.Factory
   interface Factory{
       fun create(): HomeComponent
   }
    fun inject(homeActivity: HomeActivity)
    fun inject(fragment: ContactsFragment)
    fun inject(fragment: MsgHistoryFragment)
}