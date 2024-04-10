package com.example.android.hilt.di

import android.content.Context
import androidx.room.Room
import com.example.android.hilt.data.AppDatabase
import com.example.android.hilt.data.LogDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * 모듈을 사용하여 Hilt에 바인딩 추가
 * @Module 은 Hilt에 모듈임을 알려줌
 * @InstallIn 은 어느 컨테이너에서 Hilt 구성요소를 지정하여 결합을 사용할 수 있는지 Hilt에 알려줌
 */
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context) : AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "logging.db"
        ).build()
    }

    /**
     * Hilt에 LogDao 인스턴스를 제공할때 database.logDao()가 실행되어야 한다고 알려줌
     */
    @Provides
    fun provideLogDao(database: AppDatabase) : LogDao {
        return database.logDao()
    }
}