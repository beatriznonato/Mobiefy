package app.mobiefy

import android.app.Application
import app.mobiefy.di.appModule
import app.mobiefy.di.firebaseModule
import app.mobiefy.di.storageModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.logger.Level

class Mobiefy : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Mobiefy)
            modules(
                appModule,
                storageModule,
                firebaseModule
            )
        }
    }
}
