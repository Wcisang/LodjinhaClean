package br.com.wcisang.lodjinhaclean.di.module

import br.com.wcisang.lodjinhaclean.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(FragmentBuilderModule::class))
    abstract fun bindsMainActivity() : MainActivity

}