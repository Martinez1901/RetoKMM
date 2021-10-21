package com.example.retokmm.android.ui.comic_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.example.retokmm.android.R
import com.example.retokmm.android.core.toUpper
import com.example.retokmm.android.databinding.FragmentComicInfoBinding
import com.example.retokmm.model.ComicShared
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import java.util.ArrayList


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
            //getString(R.string.characters).toUpper(),
            //getString(R.string.Creators).toUpper()
        )

        with(args.comic) {
            val comic = Gson().fromJson(this, ComicShared::class.java)
            mBinding.imgToolbarComic.load(comic.thumbnailPath)
            mBinding.tvNameComic.text = comic.title

            setupViewPager(mBinding.viewPager, comic)
            TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
                tab.text = listTitlesTabs[position]
            }.attach()
        }

        return mBinding.root
    }

    private fun setupViewPager(viewPager: ViewPager2, comic: ComicShared) {
        val adapter = SectionsPagerAdapter(requireActivity())
        adapter.addFragment(ComicDetailsFragment.newInstance(comic.description), "DETAILS")
        //adapter.addFragment(ComicCharactersFragment.newInstance("HOME", "HOME"), "CHARACTERS")
        //adapter.addFragment(ComicCreatorFragment.newInstance(Gson().toJson(comic)), "MORE INFO")
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