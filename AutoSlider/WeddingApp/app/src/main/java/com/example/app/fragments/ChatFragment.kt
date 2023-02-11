package com.example.app.fragments

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.activitys.MessageActivity
import com.example.app.adapter.ChatAdapter
import com.example.app.database.entity.FirebaseTestUser
import com.example.app.listner.ChatOnClickListener
import com.example.weddingapp.databinding.FragmentChatBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase


open class ChatFragment() : Fragment() {

    private lateinit var binding: FragmentChatBinding

    var chatList = arrayListOf<FirebaseTestUser>()
    lateinit var chatadapter: ChatAdapter

    lateinit var searchView: SearchView

    private lateinit var auth: FirebaseAuth
    lateinit var databaseReference: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false)

//        preparaData()
        databaseReference = FirebaseDatabase.getInstance().getReference()


        chatadapter = ChatAdapter(requireContext())
        binding.rcvChatfragment.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rcvChatfragment.adapter = chatadapter

        auth = Firebase.auth



        databaseReference.child("user_table").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {

                chatList.clear()
                for (posSnapshot in snapshot.children) {

                    val currentUser = posSnapshot.getValue(FirebaseTestUser::class.java)
                    if (auth.currentUser?.uid != currentUser?.uId) {
                        chatList.add(currentUser!!)
                    }

                }
                chatadapter.userList(chatList)
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })


        chatadapter.setOnlistItemClickListener(object : ChatOnClickListener {
            override fun OnChatCardClicked(pos: Int, chat: FirebaseTestUser) {
                var intent = Intent(requireContext(), MessageActivity::class.java)
                intent.putExtra("USER", chat)
                startActivity(intent)
            }

        })

        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {


            }

            override fun afterTextChanged(s: Editable) {

                filter(s.toString())
            }
        })

        return binding.root

    }

    private fun filter(text: String?) {

        var filterChatList = arrayListOf<FirebaseTestUser>()

        for (item in chatList) {

            if (text != null) {
                if (item.name?.lowercase()!!.contains(text.lowercase())) {
                    filterChatList.add(item)
                }
            }
        }

        if (filterChatList.isEmpty()) {
            Toast.makeText(requireContext(), "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            chatadapter.filterList(filterChatList)
        }
    }

}