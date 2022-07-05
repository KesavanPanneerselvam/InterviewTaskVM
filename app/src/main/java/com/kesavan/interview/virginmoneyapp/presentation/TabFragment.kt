package com.kesavan.interview.virginmoneyapp.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.kesavan.interview.virginmoneyapp.databinding.FragmentTabBinding
import com.kesavan.interview.virginmoneyapp.domain.model.PeopleItem
import com.kesavan.interview.virginmoneyapp.domain.model.RoomItem
import com.kesavan.interview.virginmoneyapp.presentation.adapter.PeopleAdapter
import com.kesavan.interview.virginmoneyapp.presentation.adapter.RoomsAdapter
import com.kesavan.interview.virginmoneyapp.utils.UIState
import org.koin.androidx.viewmodel.ext.android.viewModel

class TabFragment : Fragment() {

    private var TAB_Mode: Int = 0
    private  val binding: FragmentTabBinding by lazy {
        FragmentTabBinding.inflate(layoutInflater)
    }
    private val viewModel: VMAViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            TAB_Mode = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.responseState.observe(viewLifecycleOwner,{uistate->
            when(uistate){
                is UIState.LOADING ->{showProgressbar(uistate.isLoading)}
                is UIState.SUCCESS ->{
                    showProgressbar(false)
                    if(TAB_Mode==0) {
                        (binding.itemsList.adapter as PeopleAdapter).loadPeopleList(uistate.response as List<PeopleItem>)
                    }else{
                        (binding.itemsList.adapter as RoomsAdapter).loadRoomList(uistate.response as List<RoomItem>)
                    }
                }
                is UIState.ERROR ->{
                    showProgressbar(false)
                    Toast.makeText(context,uistate.error,Toast.LENGTH_LONG).show()
                }
            }
        })
        if(TAB_Mode==0) {
            binding.itemsList.adapter=PeopleAdapter()
            viewModel.getPeople()
        }else{
            binding.itemsList.adapter=RoomsAdapter()
            viewModel.getRooms()
        }
        return binding.root
    }

    private fun showProgressbar(isLoading:Boolean){
        binding.progressbar.visibility = if(isLoading) View.VISIBLE else View.GONE
    }

    companion object {
        const val ARG_PARAM1 = "TAB_Mode"
        @JvmStatic
        fun newInstance(tabmode: Int) =
            TabFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, tabmode)
                }
            }
    }
}