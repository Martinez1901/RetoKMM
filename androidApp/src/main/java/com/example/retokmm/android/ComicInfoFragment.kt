package com.example.retokmm.android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.retokmm.android.databinding.FragmentComicInfoBinding
import java.util.ArrayList


class ComicInfoFragment : Fragment() {

    private lateinit var mBinding: FragmentComicInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicInfoBinding.inflate(inflater, container, false)
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
        adapter.addFragment(SearchContentFragment.newInstance("HOME", "HOME"), "HOME")
        adapter.addFragment(SearchContentFragment.newInstance("Arroz", "Arroz"), "ARROZ")
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