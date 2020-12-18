package project.poifinder

import android.app.Application
import com.naver.maps.map.NaverMapSdk
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import project.poifinder.common.NAVER_MAP_CLIENT_ID
import project.poifinder.common.appModules

class POIFinderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@POIFinderApplication)
            loadKoinModules(appModules)
            fragmentFactory()
        }

        NaverMapSdk.getInstance(this).client = NaverMapSdk.NaverCloudPlatformClient(NAVER_MAP_CLIENT_ID)
    }

}