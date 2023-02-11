package com.example.vegi.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.vegi.activity.Clickevent
import com.example.vegi.activity.FirstActivity
import com.example.vegi.activity.OutPutActivity
import com.example.vegi.R
import com.example.vegi.adapter.CategoryAdapter
import com.example.vegi.adapter.SliderImageAdapter
import com.example.vegi.adapter.SubCategoryAdapter
import com.example.vegi.databinding.FragmentHomeBinding
import com.example.vegi.model.*

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val categoryList1: ArrayList<Listmodel1> = ArrayList()
    private val categoryList: ArrayList<Category> = ArrayList()
    private val subcategoryList: ArrayList<Sub> = ArrayList()
    private val sliderImageAdapter: SliderImageAdapter = SliderImageAdapter()
    private val categoryAdapter: CategoryAdapter = CategoryAdapter()
    lateinit var subcategoryAdapter: SubCategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.auto.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.auto.adapter = sliderImageAdapter
        binding.image = sliderImageAdapter

        subcategoryAdapter= SubCategoryAdapter(requireContext())

        val suData = ArrayList<Listmodel>()

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.auto)

        /*val snapHelper: SnapHelper = PagerSnapHelper()
          snapHelper.attachToRecyclerView(binding.auto)*/

        suData.add(Listmodel(1, R.drawable.image_11))
        suData.add(Listmodel(2, R.drawable.image_14))
        suData.add(Listmodel(3, R.drawable.image_11))
        suData.add(Listmodel(4, R.drawable.image_14))
        suData.add(Listmodel(5, R.drawable.image_11))
        suData.add(Listmodel(6, R.drawable.image_11))
        suData.add(Listmodel(7, R.drawable.image_14))
        suData.add(Listmodel(8, R.drawable.image_11))
        suData.add(Listmodel(9, R.drawable.image_14))
        suData.add(Listmodel(10, R.drawable.image_11))

        categoryList1.add(Listmodel1(suData))
        sliderImageAdapter.updateData1(suData)

        binding.rvCategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = categoryAdapter
        binding.adapter = categoryAdapter

        val subCatData = ArrayList<Subcategory>()

        subCatData.add(Subcategory(1, R.drawable.image_22, "ATTA"))
        subCatData.add(Subcategory(2, R.drawable.image_22, "ATTA"))
        subCatData.add(Subcategory(3, R.drawable.image_12, "Potato"))
        subCatData.add(Subcategory(4, R.drawable.image_22, "ATTA"))
        subCatData.add(Subcategory(5, R.drawable.image_22, "Potato"))
        subCatData.add(Subcategory(6, R.drawable.image_22, "Potato"))
        subCatData.add(Subcategory(7, R.drawable.image_22, "ATTA"))
        subCatData.add(Subcategory(8, R.drawable.image_12, "Potato"))
        subCatData.add(Subcategory(9, R.drawable.image_22, "ATTA"))
        subCatData.add(Subcategory(10, R.drawable.image_22, "ATTA"))

        categoryList.add(Category(1, "Categories", subCatData))

        categoryAdapter.update(subCatData)

        categoryAdapter.OnClicked(object : CategoryAdapter.catItemClicked {
            override fun itemClicked(position: Int, title: String) {
                Toast.makeText(requireContext(), "pos:$position title:$title", Toast.LENGTH_SHORT)
                    .show()
            }
            override fun ChlidData(position: Int, Img: Int, list1: ArrayList<First>) {
                Toast.makeText(requireContext(), "pos:$position", Toast.LENGTH_SHORT).show()
                 var intent = Intent(requireContext(), FirstActivity::class.java)
                intent.putExtra("title",subCatData.get(position).title)
               startActivity(intent)
            }
        })
        //parent child

        var catData = ArrayList<ItemSubCategory>()

        catData.add(ItemSubCategory(1, R.drawable.image_22, "Atta", "₹25.5/500Gram"))
        catData.add(ItemSubCategory(2, R.drawable.image_22, "Atta", "₹26.5/600Gram"))
        catData.add(ItemSubCategory(3, R.drawable.image_22, "Atta", "₹27.5/700Gram"))
        catData.add(ItemSubCategory(4, R.drawable.image_22, "Atta", "₹28.5/300Gram"))
        catData.add(ItemSubCategory(5, R.drawable.image_22, "Atta", "₹29.5/200Gram"))
        catData.add(ItemSubCategory(6, R.drawable.image_22, "Atta", "₹30.5/100Gram"))
        catData.add(ItemSubCategory(7, R.drawable.image_22, "Atta", "₹31.5/500Gram"))
        catData.add(ItemSubCategory(8, R.drawable.image_22, "Atta", "₹32.5/400Gram"))
        catData.add(ItemSubCategory(9, R.drawable.image_22, "Atta", "₹33.5/700Gram"))
        catData.add(ItemSubCategory(10, R.drawable.image_22, "Atta", "₹34.5/800Gram"))

        val catData1 = ArrayList<ItemSubCategory>()

        catData1.add(ItemSubCategory(1, R.drawable.image_12, "Potato", "₹25.5/500Gram"))
        catData1.add(ItemSubCategory(2, R.drawable.image_12, "Potato", "₹26.5/600Gram"))
        catData1.add(ItemSubCategory(3, R.drawable.image_12, "Potato", "₹27.5/700Gram"))
        catData1.add(ItemSubCategory(4, R.drawable.image_12, "Potato", "₹28.5/300Gram"))
        catData1.add(ItemSubCategory(5, R.drawable.image_12, "Potato", "₹29.5/200Gram"))
        catData1.add(ItemSubCategory(6, R.drawable.image_12, "Potato", "₹30.5/100Gram"))
        catData1.add(ItemSubCategory(7, R.drawable.image_12, "Potato", "₹31.5/500Gram"))
        catData1.add(ItemSubCategory(8, R.drawable.image_12, "Potato", "₹32.5/400Gram"))
        catData1.add(ItemSubCategory(9, R.drawable.image_12, "Potato", "₹33.5/700Gram"))
        catData1.add(ItemSubCategory(10, R.drawable.image_12, "Potato", "₹34.5/800Gram"))

        subcategoryList.add(Sub(1, "Categories", catData))
        subcategoryList.add(Sub(2, "vegitables", catData1))
        subcategoryList.add(Sub(3, "Categories", catData))
        subcategoryList.add(Sub(4, "RootVegies", catData1))

        subcategoryAdapter = SubCategoryAdapter(requireContext())
        binding.list = subcategoryAdapter
        binding.rvSubcategory.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvSubcategory.adapter = subcategoryAdapter

        subcategoryAdapter.subupdate(subcategoryList)

        subcategoryAdapter.OnClicked(object : SubCategoryAdapter.itemClicked {
            override fun seeAllClicked(
                position: Int,
                title: String,
                list: ArrayList<ItemSubCategory>
            ) {
                Toast.makeText(
                    requireContext(),
                    "pos: ${position} title:$title",
                    Toast.LENGTH_SHORT
                ).show()
               // settitla(OutPutActivity,"$title")
                var intent = Intent(requireActivity(), OutPutActivity::class.java)
                intent.putParcelableArrayListExtra("data", list)
                intent.putExtra("title",subcategoryList.get(position).title)
                startActivity(intent)
            }

            override fun ChildItemAddBtnClicked(position: Int, title: String) {
                Toast.makeText(
                    requireContext(),
                    "pos: ${position} title:$title",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun ChlidDataPasss(
                position: Int,
                Img: Int,
                i_add: Int,
                list: ArrayList<ItemSubCategory>
            ) {
                Toast.makeText(
                    requireContext(),
                    "pos: ${position}",
                    Toast.LENGTH_SHORT
                ).show()

                var intent=Intent(requireContext(), Clickevent::class.java)
                intent.putParcelableArrayListExtra("data",list)   // clickevent activity to increment and decrement value
                intent.putExtra("Add",i_add)
                //intent.putExtra("Minus",i_minus)
                startActivity(intent)
            }
        })
        return binding.root
    }

     /*fun settitla(Activity:Activity,Tag:String){
     }*/
}