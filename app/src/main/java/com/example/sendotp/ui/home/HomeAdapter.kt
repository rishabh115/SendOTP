package com.example.sendotp.ui.home

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sendotp.R

private val TAB_TITLES = arrayOf(
    R.string.tab_contacts_title,
    R.string.tab_history_title
)

/** Adapter for viewpager for home activity.
 */
class HomeAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        if(position==0)
            return ContactsFragment()
        return MsgHistoryFragment()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}