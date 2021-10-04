package com.example.retokmm.android.ui.character_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.retokmm.android.R
import com.example.retokmm.android.databinding.FragmentCharacterInfoBinding
import java.util.ArrayList


class CharacterInfoFragment : Fragment() {

    private lateinit var mBinding: FragmentCharacterInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCharacterInfoBinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.apply {
            setupViewPager(viewPager)
            tabLayout.setupWithViewPager(viewPager)
        }
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = SectionsPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(CharacterDetailsFragment.newInstance("HOME", "HOME"), getString(R.string.details))
        adapter.addFragment(CharacterComicsFragment.newInstance("HOME", "HOME"), getString(R.string.comics))
        viewPager.adapter = adapter
    }

    private class SectionsPagerAdapter(manager: FragmentManager?) :
        FragmentPagerAdapter(manager!!) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }
}