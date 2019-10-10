package de.rkasper.meineersteapp.logic

import android.content.Context
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import de.rkasper.meineersteapp.R

/**
 * Nimmt alle Klicks der MainActivity entgegen
 * und leitet die weitere Logik ein.
 */
class MainActivityListener(private val currentActivity: Context) : View.OnClickListener {

    /**
     * Wertet aus welches Widget
     * geklickt wurde.
     */
    override fun onClick(v: View?) {
        if (v is ImageButton) showChosenMonsterUserMessage(v.contentDescription.toString())
    }

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
            Toast.LENGTH_LONG
        ).show()
    }

}