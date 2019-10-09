package de.rkasper.meineersteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.main_activity_layout.*

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


    //region Listenerhandling per XML-Definiert
    fun handleButtonClicksDefinedInLayout(v: View) {
        when(v.id){
            R.id.imgBtnShowFirstMonster -> showUserMsg("Number One")
            R.id.imgBtnShowSecondMonster -> showUserMsg("Second")
            R.id.imgBtnShowThirdMonster -> showUserMsg("Third in the row")
            R.id.imgBtnShowFourthMonster -> showUserMsg("Four")

        }
    }
    //endregion

    //region UserMessage
    fun showUserMsg(strMonsterTitle : String){
        //UserMessage aus res/values/strings.xml auslesen und mit Titel verbind
        val strUserMsg = getString(R.string.strUserMsgAMonsterChoosen) + strMonsterTitle;
        Toast.makeText(this,strUserMsg,Toast.LENGTH_LONG).show()
    }
    //endregion
}
