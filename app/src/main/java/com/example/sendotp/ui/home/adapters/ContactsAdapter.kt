package com.example.sendotp.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sendotp.EXTRA_CONTACT
import com.example.sendotp.R
import com.example.sendotp.data.model.Contact
import com.example.sendotp.ui.details.ContactDetailsActivity

/**
 * Adpater for recycler view of contacts fragment.
 */
class ContactsAdapter(private val context: Context): RecyclerView.Adapter<ContactsAdapter.VH>() {
    private var dataSet = emptyList<Contact>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
      val v = LayoutInflater.from(context).inflate(R.layout.list_item_contact, parent,
          false)
        return VH(v)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    fun setData(list: List<Contact>){
        this.dataSet = list
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: VH, position: Int) {
        val contact = dataSet[position]
        holder.tvName.text = contact.getName()

        holder.v.setOnClickListener{
            val intent = Intent(context, ContactDetailsActivity::class.java).apply {
                putExtra(EXTRA_CONTACT, contact)
                setFlags(Intent.FLAG_ACTIVITY_NEW_TASK) //Required when calling startActivity via non-activity context
            }
            context.startActivity(intent)
        }
    }

    class VH(val v: View): RecyclerView.ViewHolder(v){
        var tvName = v.findViewById<AppCompatTextView>(R.id.tv_contact_item_name)
    }

}