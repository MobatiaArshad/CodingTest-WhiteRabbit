package com.ems.codingtestarshad.fragments.userDetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ems.codingtestarshad.R
import com.ems.codingtestarshad.api.models.HomeResponseItem
import com.ems.codingtestarshad.baseClass.BaseFragment
import com.ems.codingtestarshad.databinding.UserDetailFragmentBinding
import com.ems.codingtestarshad.db.UsersData
import com.ems.codingtestarshad.utils.fetch

class UserDetailFragment : BaseFragment() {

    companion object {
        fun newInstance() = UserDetailFragment()
    }

    override lateinit var viewModel: UserDetailViewModel
    lateinit var binding: UserDetailFragmentBinding
    var passed: UsersData? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = UserDetailFragmentBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[UserDetailViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        passed = arguments?.getParcelable("userData")

        binding.ScrollingImage.fetch(passed?.image!!)
        binding.CollpaseTool.title = passed?.name!!
        binding.companyTxt.text = passed?.company!!
        binding.emailTxt.text = passed?.email
        binding.websiteTxt.text = passed?.website


        binding.BckBtn.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}