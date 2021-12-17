package com.nnshende.card_database.di

import android.app.Application
import com.nnshende.yugiohcard_interactors.YugiohCardInteractors
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object YugiohCardInteractorsModule {

    @Provides
    @Singleton
    fun provideAndroidDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = YugiohCardInteractors.schema,
            context = app,
            name = YugiohCardInteractors.dbName,
        )
    }

    @Provides
    @Singleton
    fun provideYugiohCardInteractors(
        sqlDriver: SqlDriver,
    ): YugiohCardInteractors {
        return YugiohCardInteractors.build(sqlDriver = sqlDriver)
    }
}