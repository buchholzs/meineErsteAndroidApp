package de.rhistel.meinlieblingsmonster

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
<<<<<<< HEAD
import android.view.View
=======

import kotlinx.android.synthetic.main.main_activity_layout.*
>>>>>>> 6a64e85 (Initial Commit with all the files this time)

/**
 * Einstiegspunkt in die App
 */
class MainActivity : AppCompatActivity() {
<<<<<<< HEAD
    private lateinit var binding: Binding
=======

>>>>>>> 6a64e85 (Initial Commit with all the files this time)
    //region 1 Lebenszyklus

    /**
     * Startet als erstes nach dem Konstruktor
     * Setzt das Layout und generiert alle direkt
     * benoetigten Widgets. Setzt Listener
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
<<<<<<< HEAD
        //1. Layout setzen
        this.setContentView(viewModel.layout.main_activity_layout)

        //2. Setzen der Toolbar
        setSupportActionBar(mainToolbar)

        binding = ResultProfileBinding.inflate(layoutInflater)
        var view: View = binding.root
        setContentView(view)

        //3. Fab Button mit Listener belegen
        binding.fabSaveUserName.setOnClickListener { view: View ->
=======

        //1. Layout setzen
        this.setContentView(R.layout.main_activity_layout)

        //2. Setzen der Toolbar
        this.setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
>>>>>>> 6a64e85 (Initial Commit with all the files this time)
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
<<<<<<< HEAD

=======
>>>>>>> 6a64e85 (Initial Commit with all the files this time)
    //endregion

    //region 2. MenuHandling
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
<<<<<<< HEAD
        menuInflater.inflate(binding.menu.menu_main, menu)
=======
        menuInflater.inflate(R.menu.menu_main, menu)
>>>>>>> 6a64e85 (Initial Commit with all the files this time)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
<<<<<<< HEAD
            binding.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
//endregion
=======
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
    //endregion
>>>>>>> 6a64e85 (Initial Commit with all the files this time)
}
