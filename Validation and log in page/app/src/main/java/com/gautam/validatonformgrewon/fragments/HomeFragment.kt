package com.gautam.validatonformgrewon.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.gautam.validatonformgrewon.DetailActivity
import com.gautam.validatonformgrewon.MessageActivity
import com.gautam.validatonformgrewon.R
import com.gautam.validatonformgrewon.adapter.AutoAdepter
import com.gautam.validatonformgrewon.adapter.ItemAdapter
import com.gautam.validatonformgrewon.adapter.ListViewAdepter
import com.gautam.validatonformgrewon.adapter.ShoppingAdepter
import com.gautam.validatonformgrewon.dao.ClickEventCard
import com.gautam.validatonformgrewon.databinding.FragmentHomeBinding
import com.gautam.validatonformgrewon.modal.AutoViewPage
import com.gautam.validatonformgrewon.modal.Listview
import com.gautam.validatonformgrewon.utilslist.UtilList.Companion.getAlliteamList
import com.gautam.validatonformgrewon.utilslist.UtilList.Companion.getItemList
import com.gautam.validatonformgrewon.utilslist.UtilList.Companion.getshoppingList
import java.util.*

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    var iteamlist = mutableListOf<AutoViewPage>()
    lateinit var autoadepter: AutoAdepter
    lateinit var itemadepter: ItemAdapter
    lateinit var shoping: ShoppingAdepter
    lateinit var listview: ListViewAdepter

    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                Toast.makeText(requireContext(), "allow new iteam permission", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(requireContext(), "don't allow", Toast.LENGTH_SHORT)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
        Autoslieder()

        binding.imMessage.setOnClickListener {
            var intent = Intent(requireContext(), MessageActivity::class.java)
            startActivity(intent)
        }

        itemadepter = ItemAdapter(requireContext(), getItemList(requireContext()))
        binding.rcvItem.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rcvItem.adapter = itemadepter

        shoping = ShoppingAdepter(requireContext(), getshoppingList(requireContext()))
        binding.revShop.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.HORIZONTAL,
            false
        )
        binding.revShop.adapter = shoping

        listview = ListViewAdepter(requireContext(), getAlliteamList(requireContext()))
        binding.revList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.revList.adapter = listview
        listview.setOnlistItemClickListener(object : ClickEventCard {
            override fun onCardClicked(pos: Int, food: Listview) {
                var intent = Intent(requireContext(), DetailActivity::class.java)
                ActivityOptions.makeSceneTransitionAnimation(requireContext() as Activity?)
                intent.putExtra("Food", food)
                startActivity(intent)
            }
        })
    }

    private fun Autoslieder() {
        iteamlist.add(AutoViewPage(1, getString(R.string.veg_auto)))
        iteamlist.add(AutoViewPage(2, getString(R.string.burger_auto)))
        iteamlist.add(AutoViewPage(3, getString(R.string.pizza_auto)))
        iteamlist.add(AutoViewPage(4, getString(R.string.best_vegitables)))
        autoadepter = AutoAdepter(requireContext(), imagelist = iteamlist)
        binding.ivViewAutoscroll.adapter = autoadepter
        binding.dotsIndicator.attachTo(binding.ivViewAutoscroll)

        val handler = Handler(Looper.getMainLooper())
        val update = Runnable {
            if (binding.ivViewAutoscroll.currentItem == autoadepter.count - 1) {
                binding.ivViewAutoscroll.currentItem = 0
            } else {
                binding.ivViewAutoscroll.currentItem++
            }
        }

        Timer().schedule(
            object : TimerTask() {
                override fun run() {
                    handler.post(update)
                }
            },
            1000,
            2000
        )
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            }
        }
    }
}
