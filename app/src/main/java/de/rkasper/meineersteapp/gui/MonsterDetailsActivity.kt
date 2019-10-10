package de.rkasper.meineersteapp.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.rkasper.meineersteapp.R

/**
 * Zeigt ein Monster im Detail
 * sprich groß in einer ImageView an
 */
class MonsterDetailsActivity : AppCompatActivity() {

    //region 1. Lebenszyklus
    /**
     * Startet als erstes nach dem Konstruktor
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        this.setContentView(R.layout.monster_details_activity_layout)
    }
    //endregion
}
