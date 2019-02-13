package br.com.wcisang.lodjinhaclean.di

import android.app.Application
import br.com.wcisang.lodjinhaclean.MyApplication
import br.com.wcisang.lodjinhaclean.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
    ApplicationModule::class,
    ActivityBuilderModule::class,
    DataModule::class,
    ViewModelModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder

        fun build() : AppComponent
    }

    fun inject(app: MyApplication)
}