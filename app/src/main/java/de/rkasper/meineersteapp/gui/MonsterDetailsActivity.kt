package de.rkasper.meineersteapp.gui

import android.annotation.SuppressLint
import android.content.Intent.*
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import de.rkasper.meineersteapp.R
import de.rkasper.meineersteapp.databinding.ActivityDetailBinding

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

    private lateinit var binding: ActivityDetailBinding

    //region 0. Konstanten fuer Auswertungen der Extras
    private val defaultResourceType: String = "drawable"
    private val noIntExtraFound: Int = -1
    private val noDrawableIdFound: Int = 0
    //endregion

    //region 1. Lebenszyklus
    /**
     * Startet als erstes nach dem Konstruktor
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //2. Checken welche Action gesetzt wurde
        this.checkForAction(this.intent.action)

    }
    //endregion

    //region 2. Action Check
    /**
     * Checkt welche Action gesetzt wurde
     * und leitet das anzeigen des passenden
     * Bildes ein. Wenn die ACTION_VIEW gesetzt
     * wurde, ist die Activity vom MainActivityListener
     * gesteratet worden. Bei ACTION_SEND von einer anderen
     * App.
     */
    private fun checkForAction(action: String?) {

        when (action) {
            ACTION_VIEW -> showImageFromIntentExtra()
            ACTION_SEND -> showImageBasedOfTextInfoFromExternalApp()
        }
    }
    //endregion

    //region 3. Extra-Auswertung des expliziten Intentes
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
            val view: ImageView? = findViewById<ImageView>(R.id.imgvBigMonster)
            view?.setImageResource(iDrawableResId)
        }

    }
    //endregion

    //region 3. Gesendete Textinformationen von externen Apps auswerten
    /**
     * Wertet aus ob die gesendeten Textinformationen
     * einer externen App einem bekannten Dateinamen entpsrechen
     * oder nicht. Sollte die Informationen nicht ausgewertet
     * werden koennen so wird ein Standardbild gesetzt. Kann
     * es ausgewertet werden so wird das passende Bild angezeigt.
     *
     * Vorraussetzung ist das der passenden Intent-Filter im AndroidManifest.xml
     * eingefuegt wurde
     *
     * TODO 2 Textdaten externer Apps auswerten
     */
    @SuppressLint("DiscouragedApi")
    private fun showImageBasedOfTextInfoFromExternalApp() {

        //1. Monstername auslesen
        val strMonsterNameFromExternalApp = this.intent?.getStringExtra(EXTRA_TEXT)

        //2. Drawable Id auslesen
        var iDrawableResId: Int = this.resources.getIdentifier(
            strMonsterNameFromExternalApp?.trim(),
            defaultResourceType, packageName
        )

        //3. Check ob die drawableResourceId gefunden wurde oder nicht
        if (iDrawableResId == noDrawableIdFound) {

            //4. Standardbild festlegen
            iDrawableResId = R.drawable.monster01

            //UserMsg Kenn ich nicht hab ein Standardbild gesetzt
            Toast.makeText(
                this,
                R.string.strUserMsgNoPictureForSentDataChoseDefault,
                Toast.LENGTH_SHORT
            ).show()
        }

        //4. Bild anzeigen
        val view: ImageView? = findViewById<ImageView>(R.id.imgvBigMonster)
        view?.setImageResource(iDrawableResId)
    }
    //endregion
}
