package ger.girod.recipesapp

import android.app.Application
import ger.girod.recipesapp.data.dependency_injection.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class RecipesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@RecipesApplication)
            modules(appModule)
        }
    }
}