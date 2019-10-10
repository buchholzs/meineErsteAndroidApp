package de.rkasper.meineersteapp.gui

import android.content.Intent.ACTION_VIEW
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import de.rkasper.meineersteapp.R
import kotlinx.android.synthetic.main.monster_details_activity_layout.*

/**
 * Zeigt ein Monster im Detail
 * sprich gross in einer ImageView an
 * Diese Activity wertet aus welche
 * Aktion Ihrem startenden expliziten Intent
 * gesetzt wurde um zu entscheiden welches Bild
 * wie angzeigt werden muss. Sollte dem startenden
 * Intent ein Extra uebergeben worden sein so wird
 * dieses Extrahiert und dazu genutz das Bild zu setzen.
 */
class MonsterDetailsActivity : AppCompatActivity() {

    private val logTag = MonsterDetailsActivity::class.simpleName
    private val noIntExtraFound: Int = -1

    //region 1. Lebenszyklus
    /**
     * Startet als erstes nach dem Konstruktor
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        this.setContentView(R.layout.monster_details_activity_layout)

        //2. Checken welche Action gesetzt wurde
        this.checkForAction(this.intent.action)

    }

    /**
     * Checkt welche Action gesetzt wurde
     * und leitet das anzeigen des passenden
     * Bildes ein
     */
    private fun checkForAction(action: String?) {

        when (action) {
            ACTION_VIEW -> showImageFromIntentExtra()
        }
    }


    /**
     * Beschafft das Bild
     * auf Basis der dem startenenden Intent
     * uebergeben Id
     * aus res/drawable/ und weist
     * dieses in der ImageView
     */
    private fun showImageFromIntentExtra() {

        //1. Extra Key auslesen
        val strDrawableIdKey = this.getString(R.string.strDrawableIdKey)

        //2. Uebergebende Id extrahieren oder standardwert setzen sollte keine Extra gefunden werden
        val iDrawableResId: Int = this.intent.getIntExtra(strDrawableIdKey, noIntExtraFound)

        //3. Checken ob eine ResourceId als Extra gesetzt wurde oder nicht
        if (iDrawableResId > noIntExtraFound) {
            this.imgvBigMonster.setImageResource(iDrawableResId)
        }

    }
    //endregion
}
