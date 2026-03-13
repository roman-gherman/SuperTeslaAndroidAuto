package com.supertesla.aa.di

import android.content.Context
import com.supertesla.aa.core.model.AppStateManager
import com.supertesla.aa.network.hotspot.HotspotManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppStateManager(): AppStateManager {
        return AppStateManager()
    }

    @Provides
    @Singleton
    fun provideHotspotManager(@ApplicationContext context: Context): HotspotManager {
        return HotspotManager(context)
    }
}
