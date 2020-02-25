package com.example.sendotp.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sendotp.R
import com.example.sendotp.data.model.SmsHistory
import com.example.sendotp.util.formatTime

/**
 * Adapter for recycler view of message history fragment.
 */
class MsgHistoryAdapter(private val context: Context): RecyclerView.Adapter<MsgHistoryAdapter.VH>() {
    private var dataSet = emptyList<SmsHistory>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(context).inflate(
            R.layout.list_item_history, parent,
            false)
        return VH(v)
    }

    override fun getItemCount(): Int {
       return dataSet.size
    }

    fun setData(list: List<SmsHistory>){
        this.dataSet = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val msg=dataSet[position]
        holder.tvName.text = msg.name
        holder.tvMsg.text = context.getString(R.string.placeholder_otp_msg).
            format(Integer.parseInt(msg.otp))
        holder.tvTime.text = formatTime(msg.sentTime)
    }

    class VH(val v: View): RecyclerView.ViewHolder(v){
         var tvName = v.findViewById<AppCompatTextView>(R.id.tv_history_item_name)
         var tvMsg = v.findViewById<AppCompatTextView>(R.id.tv_history_item_msg)
         var tvTime = v.findViewById<AppCompatTextView>(R.id.tv_history_item_time)
    }

}