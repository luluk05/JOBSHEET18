package com.example.luluk18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawer: DrawerLayout
    lateinit var navView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navView = findViewById(R.id.nav_view)
        drawer = findViewById(R.id.drawer_layout)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "JOBSHEET 18"

        toggle = ActionBarDrawerToggle(
            this@MainActivity, drawer,
            0, 0
        )

        drawer.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return toggle.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.TO -> {
                val fragmentTo= supportFragmentManager.beginTransaction()
                fragmentTo.replace(R.id.content, ToFragment())
                fragmentTo.commit()
                drawer.closeDrawers()
            }
            R.id.PPLG ->{
                val fragmentPPLG= supportFragmentManager.beginTransaction()
                fragmentPPLG.replace(R.id.content, PplgFragment())
                fragmentPPLG.commit()
                drawer.closeDrawers()
            }
            R.id.TPfL -> {
                val fragmentTPFL = supportFragmentManager.beginTransaction()
                fragmentTPFL.replace(R.id.content, tpflFragment())
                fragmentTPFL.commit()
                drawer.closeDrawers()
            }
            R.id.BUSANA -> {
                val fragmentBUSANA = supportFragmentManager.beginTransaction()
                fragmentBUSANA.replace(R.id.content, BusanaFragment())
                fragmentBUSANA.commit()
                drawer.closeDrawers()
            }
            R.id.KULINER -> {
                val fragmentKULINER = supportFragmentManager.beginTransaction()
                fragmentKULINER.replace(R.id.content, KulinerFragment())
                fragmentKULINER.commit()
                drawer.closeDrawers()
            }
        }
        return true
    }
}