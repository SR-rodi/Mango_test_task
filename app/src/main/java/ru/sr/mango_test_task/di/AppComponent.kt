package ru.sr.mango_test_task.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.sr.mango_test_task.di.module.RefreshModule
import ru.sr.mango_test_task.di.module.UtilsModel
import ru.sr.mango_test_task.feature.auth.di.AuthRepositoryModule
import ru.sr.mango_test_task.di.module.RetrofitModule
import ru.sr.mango_test_task.feature.auth.di.AuthUseCaseModule
import ru.sr.mango_test_task.feature.profile.di.DatabaseModule
import ru.sr.mango_test_task.feature.profile.di.ProfileRepositoryModule
import ru.sr.mango_test_task.feature.profile.di.ProfileUseCaseModule
import ru.sr.mango_test_task.feature.root.presentations.ViewModelFactory
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        UtilsModel::class,
        AuthRepositoryModule::class,
        AuthUseCaseModule::class,
        DatabaseModule::class,
        ProfileUseCaseModule::class,
        ProfileRepositoryModule::class,
        RefreshModule::class
    ]
)
interface AppComponent {

    val viewModelFactory: ViewModelFactory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

}