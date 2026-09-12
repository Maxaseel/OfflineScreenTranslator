package com.example

import android.app.Application
import com.example.data.db.AppDatabase

class ScreenTranslateApp : Application() {
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
}
