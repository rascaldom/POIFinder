package project.poifinder

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import project.poifinder.project.poifinder.common.appModules

class POIFinderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@POIFinderApplication)
            loadKoinModules(appModules)
            fragmentFactory()
        }
    }

}