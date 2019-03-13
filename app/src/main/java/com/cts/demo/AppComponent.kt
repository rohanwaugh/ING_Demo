package com.cts.demo

import dagger.Component
import javax.inject.Singleton


@Component(modules = arrayOf(AppModule::class))
@Singleton
interface AppComponent {
    fun inject(dataRepository: DataRepository)
    fun inject(cardsListViewModel: HeroViewModel)
}