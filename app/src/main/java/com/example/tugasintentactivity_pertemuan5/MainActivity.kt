package com.example.tugasintentactivity_pertemuan5


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.tugasintentactivity_pertemuan5.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentPagerAdapter = FragmentPagerAdapter(this@MainActivity)
        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = fragmentPagerAdapter

        tabLayout = findViewById(R.id.tab_layout)
        TabLayoutMediator(tabLayout,viewPager) {
                tab, position ->
            tab.text  =resources.getString(TAB_TITLES[position])
        }.attach()
        supportActionBar?.elevation = 0f

        val showLogin = intent.getBooleanExtra("SHOW_LOGIN", false)
        viewPager.currentItem = if (showLogin) 0 else 1

    }
    fun moveToLogin() {
        viewPager.currentItem = 0 // Move to login fragment
    }
}