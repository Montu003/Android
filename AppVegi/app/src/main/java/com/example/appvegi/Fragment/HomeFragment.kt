package com.example.appvegi.Fragment

import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appvegi.R
import com.example.appvegi.adapter.CategoriesAdapter
import com.example.appvegi.adapterr.CategorieAdapter
import com.example.appvegi.databinding.FragmentHomeBinding
import com.example.appvegi.model.cetgoriesModel
import com.example.appvegi.model.subCatModel
import com.example.appvegi.modele.Categori
import com.example.appvegi.modele.SubCategori

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {

    lateinit var catData: MutableList<cetgoriesModel>
    private val categoryList:ArrayList<Categori> = ArrayList()
    lateinit var catadapter: CategoriesAdapter
    private val CategorieAdapter:CategorieAdapter = CategorieAdapter()
    lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.adapter = CategorieAdapter
        CategorieAdapter.update(categoryList)
        binding.rvList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.adapter = CategorieAdapter

       /* catData = mutableListOf()
        catadapter = CategoriesAdapter(this.requireContext(), catData)*/

        val subCatData = mutableListOf<subCatModel>()
        subCatData.add(subCatModel(1, R.drawable.image_1, "Atta"))
        subCatData.add(subCatModel(2, R.drawable.image_2, "Atta"))
        subCatData.add(subCatModel(3, R.drawable.image_3, "Atta"))

        catData.add(cetgoriesModel(1, "Cetgoreis", "cetegoris1", subCatData))
        catData.add(cetgoriesModel(2, "Grocery", "Grocery1", subCatData))
        catData.add(cetgoriesModel(3, "Vegitables", "Vegitables1", subCatData))

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}