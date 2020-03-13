package com.example.sendotp.ui.home

import android.content.Context
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
import com.example.sendotp.ui.home.adapters.MsgHistoryAdapter
import javax.inject.Inject

/**
 * Fragment fot message history tab.
 */
class MsgHistoryFragment : BaseFragment(){

    @Inject
    lateinit var homeViewModel: HomeViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as HomeActivity).homeComponent.inject(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_msg_history, container, false)
        val msgAdapter = MsgHistoryAdapter(activity!!.applicationContext)
        val rvHistory = root.findViewById<RecyclerView>(R.id.rv_msg_history).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = msgAdapter
        }
        assembleData(msgAdapter)
        return root
    }

    private fun assembleData(adapter: MsgHistoryAdapter){
        homeViewModel.getSmsHistory().observe(this, Observer {
            smsHistory -> adapter.setData(smsHistory)
        })
    }
}