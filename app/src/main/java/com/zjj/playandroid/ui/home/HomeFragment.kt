package com.zjj.playandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zjj.playandroid.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val data = mutableListOf<HomeBean>()
        val data = ArrayList<HomeBean>()
//        data.add(HomeBean("标题1", arrayListOf("标签1","标签2", "标签3")))
//        data.add(HomeBean("标题2", arrayListOf("标签1","标签2", "标签3")))
//        data.add(HomeBean("标题3", arrayListOf("标签1","标签2", "标签3")))
//        data.add(HomeBean("标题4", arrayListOf("标签1","标签2", "标签3")))
        val rvLayout: RecyclerView = binding.rvHome
        val layoutManager = LinearLayoutManager(context)
        rvLayout.layoutManager = layoutManager
        rvLayout.adapter = HomeAdapter(data)
        rvLayout.addItemDecoration(BlackItemDecoration(context))
        homeViewModel.getData()
        activity?.let {

            homeViewModel.data.observe(it, { homeResponse ->
                homeResponse?.let {
                    data.clear()
//                    homeResponse.datas
                    data.addAll(homeResponse.datas)
                    rvLayout.adapter?.notifyDataSetChanged()
                }

            })
        }
        return root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}