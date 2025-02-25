package com.example.tabs3

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.tabs3.ui.main.SectionsPagerAdapter
import com.example.tabs3.databinding.ActivityMainBinding
import org.json.JSONObject
import java.util.*
import com.example.tabs3.R

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val stream = resources.openRawResource(R.raw.test)
        val cities = JSONObject(Scanner(stream).nextLine())
        val cities_array = cities.getJSONArray("cities")

        // data binding предусмотрен изначально в заготовке проекта
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // список "табов"
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter

        val tabs: TabLayout = binding.tabs
        tabs.setupWithViewPager(viewPager)



    }
}