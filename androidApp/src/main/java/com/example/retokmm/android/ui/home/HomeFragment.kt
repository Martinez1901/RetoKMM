package com.example.retokmm.android.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import coil.load
import com.example.retokmm.Greeting
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var mBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mBinding.tvHome.text = greet()

        mBinding.imgHomeTest.load("http://i.annihil.us/u/prod/marvel/i/mg/5/a0/538615ca33ab0/portrait_fantastic.jpg") {
            crossfade(true)
            placeholder(R.drawable.ic_image)
        }

    }

    fun greet(): String {
        return Greeting().greetingHome()
    }
}