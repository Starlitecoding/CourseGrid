package com.example.coursesgrid.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Topic(
    @StringRes val courseNameId: Int,
    val numOfCourses: Int,
    @DrawableRes val courseImageId: Int,
)

