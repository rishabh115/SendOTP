package com.example.sendotp.ui.details

import dagger.Subcomponent

@Subcomponent
interface DetailsComponent {
    @Subcomponent.Factory
    interface Factory{
        fun create(): DetailsComponent
    }
    fun inject(detailsActivity: ContactDetailsActivity)
    fun inject(fragment: SendMsgDialog)
}