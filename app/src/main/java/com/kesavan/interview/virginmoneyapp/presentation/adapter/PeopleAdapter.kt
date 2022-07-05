package com.kesavan.interview.virginmoneyapp.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kesavan.interview.virginmoneyapp.databinding.PeopleLayoutBinding
import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.utils.colorsList
import com.kesavan.interview.virginmoneyapp.utils.loadImagefromUrl
import com.kesavan.interview.virginmoneyapp.utils.parseDate

class PeopleAdapter : RecyclerView.Adapter<PeopleViewHolder>(){

    private val peopleList: MutableList<PeopleItem> = mutableListOf()

    fun loadPeopleList(people: List<PeopleItem>) {
        peopleList.clear()
        peopleList.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        return PeopleViewHolder(PeopleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people = peopleList[position]
        holder.setInformationToTheViewHolder(people,position)
    }

    override fun getItemCount(): Int = peopleList.size
}

class PeopleViewHolder(itemView: PeopleLayoutBinding): RecyclerView.ViewHolder(itemView.root) {
    private val binding = itemView

    fun setInformationToTheViewHolder(peopleItem: PeopleItem,index: Int){
        binding.userName.text= peopleItem.getFullName()
        binding.userEmail.text= peopleItem.email
        binding.jobTitle.text= peopleItem.jobtitle
        binding.userImage.loadImagefromUrl(peopleItem.avatar)
        binding.createdAt.text=peopleItem.createdAt.parseDate()
        val color=colorsList().filter { colorName -> colorName.name.lowercase() == peopleItem.favouriteColor.replace(" ", "")  }?.single()
        color?.let {
            binding.favColor.setBackgroundColor(Color.rgb(it.r,it.g, it.b))
        }
    }
}