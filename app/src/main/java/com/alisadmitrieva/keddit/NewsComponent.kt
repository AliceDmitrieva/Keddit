package com.alisadmitrieva.keddit

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AppModule::class
    )
)

interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}