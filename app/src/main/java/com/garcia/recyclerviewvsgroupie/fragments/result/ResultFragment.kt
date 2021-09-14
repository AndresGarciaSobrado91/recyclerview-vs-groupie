package com.garcia.recyclerviewvsgroupie.fragments.result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.garcia.recyclerviewvsgroupie.MainViewModel
import com.garcia.recyclerviewvsgroupie.R
import com.garcia.recyclerviewvsgroupie.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private val binding : FragmentResultBinding by lazy {
        FragmentResultBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            var elapsedTime = viewModel.recyclerEndTime - viewModel.recyclerStartTime
            textViewRvElapsedTime.text = elapsedTime.toString()

            elapsedTime = viewModel.groupieEndTime - viewModel.groupieStartTime
            textViewGrElapsedTime.text = elapsedTime.toString()
        }
    }
}