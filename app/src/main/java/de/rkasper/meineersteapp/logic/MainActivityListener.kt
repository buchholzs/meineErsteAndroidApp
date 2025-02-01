package de.rkasper.meineersteapp.logic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import de.rkasper.meineersteapp.R
import de.rkasper.meineersteapp.gui.MonsterDetailsActivity

/**
 * Nimmt alle Klicks der MainActivity entgegen
 * und leitet die weitere Logik ein.
 * Sie nimmt eine Arbeitsreferenz auf die MainActivity entgegen
 * um die neue Activity starten zu koennen
 */
class MainActivityListener(private val currentActivity: Context) {

    //region 1. OnClick Handling

    /**
     * Wertet aus welches Widget
     * geklickt wurde.
     */
    fun onClick(tagObject: Int) {

        //1. Tag auslesen
        //val tagObject = v?.tag

        //2. SmartCast nutzen um Object zu int zu casten
        startMonsterDetailsActivity(tagObject)


    }
    //endregion

    //region 3. Neue Activity starten

    /**
     * Startet per Intent die MonsterDetailsActivity
     */
    private fun startMonsterDetailsActivity(iDrawableId: Int) {


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
            Intent(
                this.currentActivity,
                MonsterDetailsActivity::class.java
            )

        //2. Schluessel zum anhaengen der Information aus res/values/strings.xml auslesen
        val strDrawableExtraIdKeyValue = this.currentActivity.getString(R.string.strDrawableIdKey)

        //3. Erstellen des Bundles
        val extraBundle  = Bundle()

        //4. Uebergeben der ResourcId vom Tag des Buttons kommend an Bundle
        extraBundle.putInt(strDrawableExtraIdKeyValue,iDrawableId)

        //5. Bundle an Intent haengen
        intentStartMonsterDetailsActivity.putExtras(extraBundle)

        //6. Bestimmende Aktion des Intents setzen
        intentStartMonsterDetailsActivity.action = Intent.ACTION_VIEW

        //6. MainActivity startet die MonsterDetailsActivity
        this.currentActivity.startActivity(intentStartMonsterDetailsActivity)
    }
    //endregion

}