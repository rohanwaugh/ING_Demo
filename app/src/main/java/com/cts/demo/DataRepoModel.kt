package com.cts.demo

class DataRepoModel {

    var heroList: List<Hero>? = null
    lateinit var throwable: Throwable

    constructor(heroList: List<Hero>) {
        this.heroList = heroList
    }

    constructor(throwable: Throwable) {
        this.throwable = throwable
    }

}