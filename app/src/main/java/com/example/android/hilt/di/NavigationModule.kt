package com.example.android.hilt.di

import com.example.android.hilt.navigator.AppNavigator
import com.example.android.hilt.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

/**
 * 이전에 만든 DatabaseModule에 추가해야하는가?
 * 1. 모듈 이름은 제공하는 정보 유형을 전달해야함 > DatabaseModule 이라는 모듈에 탐색 결함을 포함하는 것은 적절하지 않음
 * 2. DatabaseModule은 ApplicationComponent에 설치되므로 애플리케이션 컨테이너에서 결합을 사용할 수 있음. Application 컨테이너가 아닌 Activity 정보를 사용할 수 있는 Activity 컨테이너에 설치해야함
 * 3. Hilt 모듈에는 비정적 결합 메서드와 추상 결합 메서드를 모두 포함할 수 없으므로 동일한 클래스에 @Binds 와 @Provides 주석을 배치하면 안됨
 */
@InstallIn(ActivityComponent::class)
@Module
abstract class NavigationModule {
    @Binds
    abstract fun bindNavigator(impl: AppNavigatorImpl) : AppNavigator
}