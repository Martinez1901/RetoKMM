package com.example.retokmm.android.ui.comic_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import coil.load
import com.example.retokmm.android.Character
import com.example.retokmm.android.databinding.FragmentComicInfoBinding
import java.util.ArrayList


class ComicInfoFragment : Fragment() {

    private lateinit var mBinding: FragmentComicInfoBinding
    private val args : ComicInfoFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicInfoBinding.inflate(inflater, container, false)

        mBinding.tabLayout.setupWithViewPager(mBinding.viewPager)
        with(args.character!!) {
            mBinding.imgToolbarComic.load("${thumbnailPath}/standard_fantastic.jpg")
            setupViewPager(mBinding.viewPager, this)
        }

        return mBinding.root
    }

    private fun setupViewPager(viewPager: ViewPager, character: Character) {
        val adapter = SectionsPagerAdapter(requireActivity().supportFragmentManager)
        adapter.addFragment(ComicDetailsFragment.newInstance(character.description), "DETAILS")
        adapter.addFragment(ComicCharactersFragment.newInstance("HOME", "HOME"), "CHARACTERS")
        adapter.addFragment(ComicCreatorFragment.newInstance("HOME", "HOME"), "CREATOR")
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