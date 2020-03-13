package com.example.sendotp.ui.details

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.sendotp.*
import com.example.sendotp.base.BaseActivity
import com.example.sendotp.data.Callback
import com.example.sendotp.data.model.Contact
import kotlinx.android.synthetic.main.activity_contact_details.*

/**
 * Activity for displaying contact details.
 * Receives the callback of API response via Callback
 */
class ContactDetailsActivity: BaseActivity(), View.OnClickListener, Callback {

    private lateinit var contact: Contact
    private lateinit var progress: ProgressDialog
    lateinit var detailsComponent: DetailsComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        detailsComponent = (application as SendOTPApp).appComponent.detailsComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_details)
        setTitle(getString(R.string.contact_details))
        progress = ProgressDialog(this).apply {
            isIndeterminate = true
            setMessage("Sending OTP")
        }
        contact = intent?.extras?.getParcelable<Contact>(EXTRA_CONTACT)!!
        if(contact!=null){
          initViews()
        }
        btn_details_send_msg.setOnClickListener(this)
    }
    private fun initViews(){
       tv_details_name.text = contact.getName()
       tv_details_email.text = contact.email
       tv_details_phone.text = contact.phone
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_details_send_msg -> {
                openSendDialog()
            }
        }
    }

    private fun openSendDialog(){
       val fragmentTransaction = supportFragmentManager.beginTransaction()
       val prev = supportFragmentManager.findFragmentByTag(DIALOG_TAG)
        if (prev!=null){
            fragmentTransaction.remove(prev) //remove the dialog if its already there
        }
        fragmentTransaction.addToBackStack(null)
        val dialogFragment = SendMsgDialog.newInstance(contact)
        dialogFragment.show(fragmentTransaction, DIALOG_TAG)
    }

    fun setProgressVisibility(flag: Boolean){
        if (flag){
            progress.show()
        }
        else{
            progress.dismiss()
        }
    }
    override fun onSuccess() {
       setProgressVisibility(false)
       Toast.makeText(this, SUCCESS_MSG, Toast.LENGTH_SHORT).show()
    }

    override fun onFailure(errorMsg: String) {
      setProgressVisibility(false)
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
    }
}