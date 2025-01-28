package de.rkasper.meineersteapp.gui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import de.rkasper.meineersteapp.logic.MainActivityListener
import de.rkasper.meineersteapp.databinding.ActivityMainBinding
import android.view.View
/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //region 1 Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        //1. Setzen des Layouts
        this.setContentView(viewModel.layout.main_activity_layout)
        this.setContentView(R.layout.main_activity_layout)

        /*
        * 2. Zuweisung der Zusatzinformation:
        * Welches Bild wird aktuell auf dem Button gezeigt
        */
        this.imgBtnShowFirstMonster.tag = R.drawable.monster06;
        this.imgBtnShowSecondMonster.tag = R.drawable.monster07;
        this.imgBtnShowThirdMonster.tag = R.drawable.monster12;
        this.imgBtnShowFourthMonster.tag = R.drawable.monster09;

        /*
         * 3. Listenergenerierung bei ListnerHandling in seperater Klasse
         * welche die die Klicks aller ImageButtons
         * entgegenimmt und weitere Logik einleitet.
         */
        val mainActivityListener = MainActivityListener(this)

        /*
         * 4. Listenerzuweisung bei ListenerHandling in sperater Klasse
         */
        this.imgBtnShowFirstMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowSecondMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowThirdMonster.setOnClickListener(mainActivityListener)
        this.imgBtnShowFourthMonster.setOnClickListener(mainActivityListener)

    }
    //endregion

}
