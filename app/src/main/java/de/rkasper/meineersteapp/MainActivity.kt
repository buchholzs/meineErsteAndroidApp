package de.rkasper.meineersteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    //region 1 Lebenszyklus
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        setContentView(R.layout.main_activity_layout)
    }
    //endregion
}
