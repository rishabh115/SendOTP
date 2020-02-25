package com.example.sendotp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sendotp.R
import com.example.sendotp.base.BaseFragment
import com.example.sendotp.ui.home.adapters.ContactsAdapter

/**
 * Fragment for contacts tab.
 */
class ContactsFragment : BaseFragment(){

    private lateinit var homeViewModel: HomeViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel =  ViewModelProviders.of(this).get(HomeViewModel::class.java)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_contacts, container, false)
        val contactsAdapter = ContactsAdapter(activity!!.applicationContext)
        val rvContacts = root.findViewById<RecyclerView>(R.id.rv_contacts).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = contactsAdapter
        }
        assembleData(contactsAdapter)
        return root
    }

    private fun assembleData(contactsAdapter: ContactsAdapter) {
       homeViewModel.getContacts().observe(this, Observer {
           contactsAdapter.setData(it)
       })
    }
}