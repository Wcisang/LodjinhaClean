package br.com.wcisang.lodjinhaclean

import android.os.Bundle
import br.com.wcisang.lodjinhaclean.ui.BaseActivity
import br.com.wcisang.lodjinhaclean.ui.home.HomeFragment

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, HomeFragment())
            .commit()
    }
}
