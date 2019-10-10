package de.rkasper.meineersteapp.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.rkasper.meineersteapp.logic.MainActivityListener
import de.rkasper.meineersteapp.R
import kotlinx.android.synthetic.main.main_activity_layout.*

/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {


    //region 1 Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //1. Setzen des Layouts
        this.setContentView(R.layout.main_activity_layout)



        /*
         * 2. Listenerzuweisung bei ListenerHandling in der MainActivity
         *
        this.imgBtnShowFirstMonster.setOnClickListener {
            showChosenMonsterUserMessage(it.contentDescription.toString())
        }

        this.imgBtnShowSecondMonster.setOnClickListener {
            showChosenMonsterUserMessage(it.contentDescription.toString())
        }

        this.imgBtnShowThirdMonster.setOnClickListener {
            showChosenMonsterUserMessage(it.contentDescription.toString())
        }

        this.imgBtnShowFourthMonster.setOnClickListener {
            showChosenMonsterUserMessage(it.contentDescription.toString())
        }
        */

        /**
         * 3. Listenergenerierung bei ListnerHandling in seperater Klasse
         * welche die die Klicks aller ImageButtons
         * entgegenimmt und weitere Logik einleitet.
         */
        val mainActivityListener = MainActivityListener(this)

        /*
         * 3. Listenerzuweisung bei ListenerHandling in sperater Klasse
         */
        this.imgBtnShowFirstMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowSecondMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowThirdMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowFourthMonster.setOnClickListener(mainActivityListener)


    }
    //endregion


    //region 1. Listenerhandling per XML-Definiert
    /**
     * Leitet das anzeigen einer Usernachricht an.
     * Wurde im res/layout/main_activity_layout fuer
     * jeden Button mit dem Attribut onClick festgelegt
     * Moeglichkeit wenn nicht viel an Logik ausgefuehrt
     * werden muss oder nur andere Activities aufgerufen
     * werden
     */
//    fun handleButtonClicksDefinedInLayout(v: View) {
//        showChosenMonsterUserMessage(v.contentDescription.toString())
//    }
    //endregion

    //region 2. Listenerhandling in der MainActivity
    /**
     * Nimmt die Content Description
     * eines geklickten ImageButtons entgegen
     * und zeigt diesen mit einer in der
     * res/values/strings.xml definierten Nachricht auf
     * der aktuellen Activity(MainActivity) an.

    private fun showChosenMonsterUserMessage(strContentDescription: String) {
        //UserMessage aus res/values/strings.xml auslesen und mit der Inhaltsbeschreibung verbinden
        val strUserMsg =
            getString(R.string.strUserMsgYouHaveChoosenAmonster) + " " + strContentDescription

        //Toast ausgeben Aktivity auf der er angezeigt wird,Nachricht, Anzeigedauer
        Toast.makeText(this, strUserMsg, Toast.LENGTH_LONG).show()
    }
     */
    //endregion

}
