package com.garcia.recyclerviewvsgroupie.fragments.groupieFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.garcia.recyclerviewvsgroupie.MainViewModel
import com.garcia.recyclerviewvsgroupie.R
import com.garcia.recyclerviewvsgroupie.databinding.FragmentRecyclerviewBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class GroupieFragment : Fragment() {

    private val binding : FragmentRecyclerviewBinding by lazy {
        FragmentRecyclerviewBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel
    private val ohlcListAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        initGroupie()

        binding.buttonContinue.setOnClickListener {
            findNavController().navigate(R.id.action_groupieFragment_to_resultFragment)
        }
    }

    private fun initGroupie() {
        val data = viewModel.mockedData
        val startTime = System.currentTimeMillis()
        viewModel.groupieStartTime = startTime
        binding.recyclerView.setHasFixedSize(true)
        data.let { list ->
            ohlcListAdapter.update(list.map { item ->
                GroupieView(item){
                    viewModel.groupieEndTime = it
                }
            })
        }
        binding.recyclerView.adapter = ohlcListAdapter
    }
}