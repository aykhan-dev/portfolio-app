package ev.aykhn.portfolio

import android.app.Application
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import ev.aykhn.portfolio.data.di.dataModule
import ev.aykhn.portfolio.domain.di.domainModule
import ev.aykhn.portfolio.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        startKoin{
            androidLogger()
            androidContext(this@App)
            modules(
                presentationModule,
                domainModule,
                dataModule,
            )
        }
    }

}