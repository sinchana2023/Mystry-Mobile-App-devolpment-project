package com.example.mad_aat

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Home : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        val drawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
        val txt=findViewById<TextView>(R.id.textView3)
        txt.setOnClickListener {
            val sub = Intent(this, Category::class.java)
            startActivity(sub)
            // using finish() to end the activity
            finish()

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                // Handle "About" item click
                startActivity(Intent(this,About::class.java))
            }
            R.id.item2 -> {
                startActivity(Intent(this,FAQS::class.java))
            }
            R.id.item3 -> {
                startActivity(Intent(this,contact::class.java))
            }
            R.id.item4 -> {
                startActivity(Intent(this,LoginActivity::class.java))
               finish()
            }
            // Add more cases for other menu items if needed

            else -> return false
        }

        // Close the drawer after handling the item click
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}
