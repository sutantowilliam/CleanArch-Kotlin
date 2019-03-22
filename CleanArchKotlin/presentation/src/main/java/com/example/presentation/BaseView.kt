package com.example.presentation

interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter: T)
}