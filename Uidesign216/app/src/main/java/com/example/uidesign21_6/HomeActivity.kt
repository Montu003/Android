package com.example.uidesign21_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId)
        {
            R.id.action_setting->{
                Toast.makeText(applicationContext,"Item selected : setting", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_search->{
                Toast.makeText(applicationContext, "Item selected : search ", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_help->{
                Toast.makeText(applicationContext, "Item selected : help", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout->{
                Toast.makeText(applicationContext, "Item selected : Logout", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}