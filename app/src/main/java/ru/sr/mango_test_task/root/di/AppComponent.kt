package ru.sr.mango_test_task.root.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.sr.mango_test_task.root.di.module.ProviderModel
import ru.sr.mango_test_task.root.di.module.RetrofitModule
import ru.sr.mango_test_task.root.presentation.viewmodelfactory.ViewModelFactory
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        ProviderModel::class
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