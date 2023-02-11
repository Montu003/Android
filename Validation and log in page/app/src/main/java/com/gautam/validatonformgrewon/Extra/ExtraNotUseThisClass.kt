package com.gautam.validatonformgrewon.Extra

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gautam.validatonformgrewon.databinding.ActivityMessageBinding
import com.gautam.validatonformgrewon.modal.SendDataFaireBase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ExtraNotUseThisClass {

    /*class MessageActivity : AppCompatActivity() {

        lateinit var biniding: ActivityMessageBinding
        var firebaseDatabase: FirebaseDatabase? = null//
        var databaseReference: DatabaseReference? = null//dbrefrence


        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            biniding = ActivityMessageBinding.inflate(layoutInflater)
            setContentView(biniding.root)

            firebaseDatabase = FirebaseDatabase.getInstance();
            databaseReference = firebaseDatabase!!.getReference("User")

            //  firebaseDatabase = FirebaseDatabase.getInstance();

            biniding.btSubmit.setOnClickListener {

                var name = biniding.etName.text.toString()
                var age=biniding.etAge.text.toString()

                databaseReference = FirebaseDatabase.getInstance().getReference("User")
                // val mRef: DatabaseReference = databaseReference.getReference().child("Users")
                databaseReference!!.push().key
                databaseReference!!.push().key?.let {
                    val user = SendDataFaireBase(it,name,age)
                    databaseReference!!.child("User").setValue(user).addOnCompleteListener {


                        if(it.isSuccessful)
                            Toast.makeText(this, "Add data successfully", Toast.LENGTH_SHORT).show()
                        Log.d("TAG", "onCreate: ")

                    }

                }


                *//*  database

                  database.child.setValue(user)?.addOnSuccessListener {

                      database.setValue(user )
                      databaseReference!!.setValue(user);
                      biniding.etName.setText(user.name)
                      biniding.etEmail.setText(user.email)
                      Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

                  }?.addOnFailureListener{

                      Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()


                  }*//*


            }
        }
    }*/
    //        holder.itemView.setOnClickListener {
//            AlertDialog.Builder(context)
//                .setTitle("Delete")
//                .setMessage("Are You Sure you want to Delete your Message")
//                .setPositiveButton("yes"
//                ) { dialog: DialogInterface?, which: Int ->
//                    var database = FirebaseDatabase.getInstance().reference
//                    database.child("chats").child(senderRoom).child("messages")
//                        .child(currentmessage.messageId).removeValue()
//                    database.child("chats").child(receiverRoom).child("messages")
//                        .child(currentmessage.messageId).removeValue()
//                }.setPositiveButton("No",
//                    DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
//                        dialog!!.dismiss()
//                    }).show()
//
//
//        }
}