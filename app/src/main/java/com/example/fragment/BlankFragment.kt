package com.example.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.fragment.databinding.Fragment1Binding

class BlankFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var fBind: Fragment1Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        fBind = Fragment1Binding.inflate(inflater)
        return fBind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForFrag1.observe(activity as LifecycleOwner) {
            fBind.tvFragment1.text = it
        }

        fBind.btnSendToFragment2.setOnClickListener {
            dataModel.messageForFrag2.value = "Hello from fragment 1"
        }

        fBind.btnSendToActivity.setOnClickListener {
            dataModel.messageForActivity.value = "Hello activity from fragment 1"
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = BlankFragment()
    }
}