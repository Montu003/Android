package com.example.menus23_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.menus23_6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        registerForContextMenu(binding.btnContext)

        binding.btnPopup.setOnClickListener {

            var popMenu = PopupMenu(this,it )
            menuInflater.inflate(R.menu.option_menu, popMenu.menu)
            popMenu.show()

            popMenu.setOnMenuItemClickListener {
                return@setOnMenuItemClickListener when(it.itemId){
                    R.id.action_search ->{
                        startActivity(Intent(this, SearchActivity::class.java))
                        true
                    }
                    R.id.action_logout ->{
                        Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                        true
                    }
                    R.id.action_help ->{
                        startActivity(Intent(this, "help"::class.java))
                        true
                    }
                    R.id.action_setting ->{
                        Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> {false}
                }
            }
        }
    }


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.option_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {

        return when(item.itemId){
            R.id.action_search ->{
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            R.id.action_logout ->{
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help ->{
                startActivity(Intent(this, "help"::class.java))
                true
            }
            R.id.action_setting ->{
                Toast.makeText(this, "Setting", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.action_setting->{
                Toast.makeText(applicationContext,"Item selected : setting",Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_search->{
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            R.id.action_help->{
                Toast.makeText(applicationContext, "Item selected : help", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout->{
                showsimpleDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showsimpleDialog() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
            .setMessage("are you sure you want to logout from this application")
            .setPositiveButton("Logout", { dialog ,i ->
                Toast.makeText(this, "positive button clicked", Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel",{dialogInterface,i ->
                Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
            }).show()
    }
}