package com.kesavan.interview.virginmoneyapp.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.kesavan.interview.virginmoneyapp.R
import com.kesavan.interview.virginmoneyapp.databinding.RoomLayoutBinding
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import com.kesavan.interview.virginmoneyapp.utils.loadImagefromUrl

class RoomsAdapter : RecyclerView.Adapter<RoomViewHolder>(){

    private val roomList: MutableList<RoomItem> = mutableListOf()

    fun loadRoomList(people: List<RoomItem>) {
        roomList.clear()
        roomList.addAll(people)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        return RoomViewHolder(RoomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
        val people = roomList[position]
        holder.setInformationToTheViewHolder(people,position)
    }

    override fun getItemCount(): Int = roomList.size
}

class RoomViewHolder(itemView: RoomLayoutBinding): RecyclerView.ViewHolder(itemView.root) {
    private val binding = itemView

    fun setInformationToTheViewHolder(roomItem: RoomItem, index: Int){
        binding.roomNo.text= "Room No: ${roomItem.id}"
        if(roomItem.isOccupied)
            binding.status.background= ContextCompat.getDrawable(binding.root.context,R.drawable.ic_room_available)
        else
            binding.status.background= ContextCompat.getDrawable(binding.root.context,R.drawable.ic_room_occupied)
        val imgurl="https://photos.hotelbeds.com/giata/00/004200/004200a_hb_ro_00${(1..9).random()}.jpg"
        binding.roomImage.loadImagefromUrl(imgurl)
    }
}