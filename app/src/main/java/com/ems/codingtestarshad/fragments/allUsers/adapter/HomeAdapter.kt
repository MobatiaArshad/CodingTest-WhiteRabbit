package com.ems.codingtestarshad.fragments.allUsers.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ems.codingtestarshad.api.models.HomeResponseItem
import com.ems.codingtestarshad.databinding.HomeRecLytBinding
import com.ems.codingtestarshad.utils.fetch

class HomeAdapter(val array: List<HomeResponseItem>): RecyclerView.Adapter<HomeAdapter.HomeVH>() {

    inner class HomeVH(val binding: HomeRecLytBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH =
        HomeVH(HomeRecLytBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        holder.binding.apply {
            holder.itemView.apply {
                array[position].let {

//                    userImg.fetch(it.profileImage)
                    userName.text = it.name
                    userCompany.text = it.company?.name


                }
            }
        }

    }

    override fun getItemCount(): Int = array.size

}