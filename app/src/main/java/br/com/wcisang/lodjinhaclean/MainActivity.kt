package br.com.wcisang.lodjinhaclean

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.wcisang.lodjinhaclean.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.mainContainer, HomeFragment())
            .commit()
    }
}
