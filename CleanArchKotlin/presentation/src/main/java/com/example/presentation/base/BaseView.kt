package com.example.presentation.base

interface BaseView<in T : BasePresenter> {
    fun setPresenter(presenter: T)
}