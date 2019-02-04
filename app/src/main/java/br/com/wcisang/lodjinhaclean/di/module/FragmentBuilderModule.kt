package br.com.wcisang.lodjinhaclean.di.module

import br.com.wcisang.lodjinhaclean.ui.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindsHomeFragment() : HomeFragment

}