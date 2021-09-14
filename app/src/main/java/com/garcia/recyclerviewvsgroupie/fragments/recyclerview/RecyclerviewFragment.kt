package com.garcia.recyclerviewvsgroupie.fragments.recyclerview

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
import java.util.Calendar

class RecyclerviewFragment : Fragment() {

    private val binding: FragmentRecyclerviewBinding by lazy {
        FragmentRecyclerviewBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        initRecyclerView()

        binding.buttonContinue.setOnClickListener {
            findNavController().navigate(R.id.action_recyclerviewFragment_to_groupieFragment)
        }
    }

    private fun initRecyclerView() {
        val data = viewModel.mockedData
        val startTime = System.currentTimeMillis()
        viewModel.recyclerStartTime = startTime
        binding.recyclerView.setHasFixedSize(true)
        val uiAdapter = RVAdapter(){
            viewModel.recyclerEndTime = it
        }
        uiAdapter.data = data
        binding.recyclerView.adapter = uiAdapter
        uiAdapter.notifyDataSetChanged()
    }
}