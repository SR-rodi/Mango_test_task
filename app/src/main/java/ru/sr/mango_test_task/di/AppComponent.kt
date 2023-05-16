package ru.sr.mango_test_task.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.sr.mango_test_task.di.module.ProviderModel
import ru.sr.mango_test_task.feature.auth.di.RepositoryModule
import ru.sr.mango_test_task.di.module.RetrofitModule
import ru.sr.mango_test_task.feature.auth.di.UseCaseModule
import ru.sr.mango_test_task.feature.root.presentations.ViewModelFactory
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        ProviderModel::class,
        RepositoryModule::class,
        UseCaseModule::class,
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