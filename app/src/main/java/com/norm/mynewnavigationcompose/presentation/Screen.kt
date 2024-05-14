package com.norm.mynewnavigationcompose.presentation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screen {
    @Serializable
    data object Home : Screen()

    @Serializable
    data class Profile(
        val id: Int,
    ) : Screen()
}