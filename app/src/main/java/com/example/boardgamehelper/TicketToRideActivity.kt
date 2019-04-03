package com.example.boardgamehelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.Menu
import kotlinx.android.synthetic.main.activity_ticket_to_ride.*


class TicketToRideActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_to_ride)
        setSupportActionBar(findViewById(R.id.main_activity_toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val adapter = SegmentPagerAdapter(supportFragmentManager)
        adapter.addFragment(TicketGermanyFragment() , getString(R.string.ger_text))
        adapter.addFragment(TicketEuropeFragment() , getString(R.string.eur_text))
        adapter.addFragment(TicketUKFragment() , getString(R.string.uk_text))
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    class SegmentPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment,title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }

}
