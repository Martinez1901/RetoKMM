package com.example.retokmm.android.ui.character_info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.retokmm.android.R
import com.example.retokmm.android.core.toUpper
import com.example.retokmm.android.databinding.FragmentCharacterInfoBinding
import com.example.retokmm.model.CharacterShared
import com.google.gson.Gson


class CharacterInfoFragment : Fragment() {

    private lateinit var mBinding: FragmentCharacterInfoBinding
    //private val args: CharacterInfoFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCharacterInfoBinding.inflate(inflater, container, false)

        val listTitlesTabs = listOf(
            getString(R.string.details).toUpper(),
            getString(R.string.comics).toUpper(),
        )

        val character = Gson().fromJson("falfjdlajf", CharacterShared::class.java)

        /*with(args.character!!) {
            mBinding.imgToolbarCharacter.load("${thumbnailPath}/standard_fantastic.jpg")
            mBinding.tvNameChracter.text = name

            setupViewPager(mBinding.viewPager, this)
            TabLayoutMediator(mBinding.tabLayout, mBinding.viewPager) { tab, position ->
                tab.text = listTitlesTabs[position]
            }.attach()
        }*/

        return mBinding.root
    }

    /*private fun setupViewPager(viewPager: ViewPager2, character: Character) {
        val adapter = SectionsPagerAdapter(requireActivity())
        adapter.addFragment(CharacterDetailsFragment.newInstance(character.description), getString(R.string.details))
        adapter.addFragment(CharacterComicsFragment.newInstance("HOME", "HOME"), getString(R.string.comics))
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
    }*/
}