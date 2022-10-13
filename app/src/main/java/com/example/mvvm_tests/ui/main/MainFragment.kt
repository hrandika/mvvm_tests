package com.example.mvvm_tests.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import com.example.mvvm_tests.R
import com.example.mvvm_tests.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
       binding =  DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false)
       binding.vm = viewModel
       return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       viewModel.score.observe(viewLifecycleOwner) {
         binding.message?.text = it.toString()
       }

        viewModel.playlist.observe(viewLifecycleOwner) {
            Log.d("MainFragment", it[0].title)
//            binding.message.text = it[0].title
        }

        viewModel.eventNetworkError.observe(viewLifecycleOwner) {
            Log.d("MainFragment", "Errorr ${it}")
        }
    }

}