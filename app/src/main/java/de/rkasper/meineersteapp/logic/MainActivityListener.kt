package de.rkasper.meineersteapp.logic

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import de.rkasper.meineersteapp.R
import de.rkasper.meineersteapp.gui.MonsterDetailsActivity

/**
 * Nimmt alle Klicks der MainActivity entgegen
 * und leitet die weitere Logik ein.
 */
class MainActivityListener(private val currentActivity: Context) : View.OnClickListener {

    //region 1. Klickhandling
    /**
     * Wertet aus welches Widget
     * geklickt wurde.
     */
    override fun onClick(v: View?) {
        if (v is ImageButton) showChosenMonsterUserMessage(v.contentDescription.toString())

       startMonsterDetailsActivity()
    }
    //endregion


    //region  2. UserMsg ausgeben

    /**
     * Nimmt die Content Description
     * eines geklickten ImageButtons entgegen
     * und zeigt diesen mit einer in der
     * res/values/strings.xml definierten Nachricht auf
     * der aktuellen Activity(MainActivity) an.
     */
    private fun showChosenMonsterUserMessage(strContentDescription: String) {
        //UserMessage aus res/values/strings.xml auslesen und mit der Inhaltsbeschreibung verbinden
        val strUserMsg =
            this.currentActivity.getString(R.string.strUserMsgYouHaveChoosenAmonster)

        //Toast ausgeben Aktivity auf der er angezeigt wird,Nachricht, Anzeigedauer
        Toast.makeText(
            this.currentActivity,
            "$strUserMsg $strContentDescription",
            Toast.LENGTH_SHORT
        ).show()
    }
    //endregion

    //region 3. Neue Activity starten

    /**
     * Startet per Intent die MonsterDetailsActivity
     */
    private fun startMonsterDetailsActivity() {

        /*
         * 1. Explizites Intent generieren
         * Ein Intent ist ein Nachrichtenobjekt
         * von Android und kapselt im Konstruktor
         * die Informatioen welche Absicht(engl. Intent)
         * man hat. Dieses Intent ist deswegen explizit
         * weil wir als Entwickler explizit Angeben welche
         * Activity welche startet. In unserem Fall startet
         * die MainActivity die MonsterDetailsActivity. Die
         * Startende Activity ist immer Context-Objekt die
         * Zielactivity ist immer eine class-Angabe.
         */
        val intentStartMonsterDetailsActivity =
            Intent(this.currentActivity,
                MonsterDetailsActivity::class.java)


        //2. MainActivity startet die MonsterDetailsActivity
        this.currentActivity.startActivity(intentStartMonsterDetailsActivity)
    }
    //endregion

}