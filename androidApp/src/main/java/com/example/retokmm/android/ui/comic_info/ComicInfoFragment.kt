package com.example.retokmm.android.ui.comic_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.fragment.navArgs
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.retokmm.android.Character
import com.example.retokmm.android.R
import com.example.retokmm.android.core.capitalized
import com.example.retokmm.android.core.toUpper
import com.example.retokmm.android.databinding.FragmentComicInfoBinding
import com.google.android.material.tabs.TabLayout
import java.util.ArrayList
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy


class ComicInfoFragment : Fragment() {

    private lateinit var mBinding: FragmentComicInfoBinding
    private val args: ComicInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentComicInfoBinding.inflate(inflater, container, false)

        val listTitlesTabs = listOf(
            getString(R.string.details).toUpper(),
            getString(R.string.characters).toUpper(),
            getString(R.string.Creators).toUpper()
        )

        with(args.character!!) {
            mBinding.imgToolbarComic.load("${thumbnailPath}/standard_fantastic.jpg")
            mBinding.tvNameComic.text = name

            setupViewPager(mBinding.viewPager, this)
            TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
                tab.text = listTitlesTabs[position]
            }.attach()
        }

        return mBinding.root
    }

    private fun setupViewPager(viewPager: ViewPager2, character: Character) {
        val adapter = SectionsPagerAdapter(requireActivity())
        adapter.addFragment(ComicDetailsFragment.newInstance(character.description), "DETAILS")
        adapter.addFragment(ComicCharactersFragment.newInstance("HOME", "HOME"), "CHARACTERS")
        adapter.addFragment(ComicCreatorFragment.newInstance("HOME", "HOME"), "CREATOR")
        viewPager.adapter = adapter
    }


    private class SectionsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()

        override fun getItemCount(): Int = mFragmentList.size

        override fun createFragment(position: Int): Fragment {
            return mFragmentList[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }
    }


}