package com.example.app.activitys

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.adapter.MessageAdapter
import com.example.app.database.entity.FirebaseTestUser
import com.example.app.database.entity.Message
import com.example.weddingapp.databinding.ActivityMessageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import java.util.*

class MessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageBinding

    lateinit var messageAdapter: MessageAdapter
    lateinit var databaseReference: DatabaseReference


    private lateinit var auth: FirebaseAuth

    var messageList = arrayListOf<Message>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val userData = intent.getParcelableExtra<FirebaseTestUser>("USER")
        binding.tvUsername.text = userData?.name

        // var prefManagr = PrefManagr(this)


        auth = Firebase.auth

        databaseReference = FirebaseDatabase.getInstance().getReference("user_table")


        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.bottomBar, InputMethodManager.SHOW_IMPLICIT)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        var layoutManager =   LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        layoutManager.stackFromEnd = true
        messageAdapter = MessageAdapter(this, userData?.uId)
        binding.rcvMessage.layoutManager =layoutManager
        binding.rcvMessage.adapter = messageAdapter



        databaseReference.child(auth.currentUser?.uid ?: "").child("message")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messageList.clear()
                    for (DataSnapshot in snapshot.children) {

                        val messageData = DataSnapshot.getValue(Message::class.java)
                        Log.e("TAG", "onDataChange: " + Gson().toJson(messageData))
                        messageData?.let { messageList.add(it) }
                    }
                    binding.rcvMessage.scrollToPosition(messageList.size-1)
                    messageAdapter.setMessageList(messageList)
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })


        binding.btnSend.setOnClickListener {

            var message = binding.etMessage.text.toString()


            val messageObject = Message(

                senderId = FirebaseAuth.getInstance().currentUser?.uid,
                message = message,
                time = Calendar.getInstance().getTimeInMillis()

            )

            if (binding.etMessage.text.isNotBlank()) {
                 binding.etMessage.hideKeyboard()

                binding.etMessage.setText("")
                databaseReference.child(auth.currentUser?.uid ?: "").child("message").push()
                    .setValue(messageObject).addOnSuccessListener {
                    databaseReference.child(userData?.uId ?: "").child("message").push()
                        .setValue(messageObject)
                }
            }

        }

    }

    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

}