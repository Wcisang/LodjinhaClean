package br.com.wcisang.lodjinhaclean.di.module

import android.app.Application
import android.content.Context
import br.com.wcisang.domain.executor.PostExecutionThread
import br.com.wcisang.lodjinhaclean.UiThread
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread) : PostExecutionThread

    @Binds
    abstract fun bindContext(application: Application) : Context
}