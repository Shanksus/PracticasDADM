package upv.dadm.devalent.practicainterfaz.di

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NewQuotationProviderModule {
    @ApplicationContext
    @Provides
    @Singleton
    fun provideConnectivityManager (context: Context): ConnectivityManager {
        return context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
    }
}