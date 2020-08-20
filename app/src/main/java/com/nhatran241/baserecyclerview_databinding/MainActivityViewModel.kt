package com.nhatran241.baserecyclerview_databinding

import android.graphics.Color
import java.util.*

class MainActivityViewModel{
    var listColor =
        listOf(
            ItemColorViewModel(bgColor = Color.BLACK),
            ItemColorViewModel(bgColor = Color.BLUE),
            ItemColorViewModel(bgColor = Color.CYAN),
            ItemColorViewModel(bgColor = Color.DKGRAY),
            ItemColorViewModel(bgColor = Color.GRAY),
            ItemColorViewModel(bgColor = Color.LTGRAY),
            ItemColorViewModel(bgColor = Color.MAGENTA),
            ItemColorViewModel(bgColor = Color.GREEN),
            ItemColorViewModel(bgColor = Color.YELLOW))

}