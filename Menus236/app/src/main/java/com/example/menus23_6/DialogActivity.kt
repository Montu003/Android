package com.example.menus23_6

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.menus23_6.databinding.ActivityCustomDialogLayoutBinding

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
    }

    fun onButtonClicked(view: View) {
        when(view.id)
        {
            R.id.btn_simple_dialog ->{
                showsimpleDialog()
            }
            R.id.btn_single_choice_dialog ->{
                showSinglechoiceDailog()
            }
            R.id.btn_single_choice_dialog2 ->{
                showSinglechoiceDailogwithRedio()
            }
            R.id.btn_multi_choice_dialog ->{
                showMultichoiceDialog()
            }
            R.id.btn_custom_dialog ->{
                showCustomDialog()
            }
        }
    }

    private fun showCustomDialog() {
        var builder = AlertDialog.Builder(this)
        var bind = ActivityCustomDialogLayoutBinding.inflate(layoutInflater)
        builder.setView(bind.root)

        var dialog = builder.create()
        dialog.show()

        bind.btnSubmit.setOnClickListener {
            Toast.makeText(this, "successfully submitted", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        bind.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun showMultichoiceDialog() {
        var colors = arrayOf("Red","Blue","Black","Green","Pink","White","Orange")
        var list  = mutableListOf<String>()
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Select color")
            .setMultiChoiceItems(colors,null, DialogInterface.OnMultiChoiceClickListener { dialogInterface, i, status  ->

                var color = colors[i]

                if (status){
                    list.add(color)
                }else{
                    list.remove(color)
                }
                Toast.makeText(this, "$list", Toast.LENGTH_SHORT).show()
            }).show()
    }

    private fun showSinglechoiceDailogwithRedio() {
        var colors = arrayOf("Red","Blue","Black","Green","Pink","White","Orange")
        var color = ""
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Pink a color")
            .setSingleChoiceItems(colors,-1, DialogInterface.OnClickListener { dialogInterface, i ->
                color = colors[i]
            }).setPositiveButton("Done", { dialog ,i ->
                Toast.makeText(this, "$color", Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel",{dialogInterface,i ->
                Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
            }).show()
    }

    private fun showSinglechoiceDailog() {
        var color = arrayOf("Red","Blue","Black","Green","Pink","White","Orange")
         var builder = AlertDialog.Builder(this)
        builder.setTitle("Pink a color")
            .setItems(color, DialogInterface.OnClickListener { dialogInterface, i ->
                var color = color[i]
                Toast.makeText(this, "$color", Toast.LENGTH_SHORT).show()
            }).show()
    }

    private fun showsimpleDialog() {
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
            .setMessage("are you sure you want to logout from this application")
            .setPositiveButton("Logout", { dialog ,i ->
                Toast.makeText(this, "positive button clicked", Toast.LENGTH_SHORT).show()
            }).setNegativeButton("cancel",{dialogInterface,i ->
                Toast.makeText(this, "Negative button clicked", Toast.LENGTH_SHORT).show()
            }).show()
    }
}