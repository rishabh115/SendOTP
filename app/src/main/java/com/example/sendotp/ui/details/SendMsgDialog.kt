package com.example.sendotp.ui.details

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.example.sendotp.EXTRA_CONTACT
import com.example.sendotp.FROM
import com.example.sendotp.R
import com.example.sendotp.data.Callback
import com.example.sendotp.data.model.Contact
import com.example.sendotp.data.model.SmsRequest
import com.example.sendotp.util.formatPhoneNumber
import com.example.sendotp.util.getRandomNumber
import com.google.android.material.textfield.TextInputEditText
import javax.inject.Inject

/**
 *  Dialog fragment for sending OTP to the current contact.
 */
class SendMsgDialog: DialogFragment() {

    @Inject
    lateinit var detailsViewModel: DetailsViewModel
    private lateinit var currContact: Contact
    private lateinit var etMsg: TextInputEditText

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as ContactDetailsActivity).detailsComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        currContact = arguments?.getParcelable<Contact>(EXTRA_CONTACT)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_send_msg, container, false)
        initViews(view)
        return view
    }

    private fun initViews(view: View) {
      val tvName = view.findViewById<AppCompatTextView>(R.id.tv_send_msg_name)
      etMsg = view.findViewById<TextInputEditText>(R.id.et_send_msg)
      val btnSendMsg = view.findViewById<AppCompatButton>(R.id.btn_send_msg)

      tvName.text = getString(R.string.placeholder_to_contact).format(currContact.getName())
      val otp = getRandomNumber()
      etMsg.setText(getString(R.string.placeholder_otp_msg).format(otp))
      btnSendMsg.setOnClickListener{sendMessage(otp)}
    }

    private fun sendMessage(otp: Int){
      val content = etMsg.text.toString().trim()
      val requestBody = SmsRequest(formatPhoneNumber(currContact.phone), FROM, content)
      val parent = activity as ContactDetailsActivity
      parent.setProgressVisibility(true)
      detailsViewModel.sendSms(requestBody, otp, currContact.getName(), parent)
      dismiss()
    }

    companion object {
        @JvmStatic
        fun newInstance(contact: Contact): SendMsgDialog{
            val sendMsgDialog = SendMsgDialog()

            val args = Bundle()
            args.putParcelable(EXTRA_CONTACT, contact)
            sendMsgDialog.arguments = args
            return sendMsgDialog
        }
    }

}