package com.ems.codingtestarshad.fragments.allUsers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import com.ems.codingtestarshad.R
import com.ems.codingtestarshad.baseClass.BaseFragment
import com.ems.codingtestarshad.databinding.HomeFragmentBinding
import com.ems.codingtestarshad.databinding.HomeRecLytBinding
import com.ems.codingtestarshad.db.UsersData
import com.ems.codingtestarshad.db.userDataBase
import com.ems.codingtestarshad.fragments.allUsers.adapter.HomeAdapter
import com.ems.codingtestarshad.utils.isOnline

class HomeFragment : BaseFragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override lateinit var viewModel: HomeViewModel
    lateinit var binding: HomeFragmentBinding
    lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        if (isOnline(requireContext())) viewModel.getUserData()
        else viewModel.getOfflineData()

        viewModel.onDataUploaded.observe(viewLifecycleOwner, Observer {
            adapter = HomeAdapter(userDataBase.getDatabase(requireContext()).userDao().getAll() as ArrayList<UsersData>)
            binding.homeRec.adapter = adapter
        })

        binding.searchEdt.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }

        })


    }

}