package com.packagesayur.yursayur.fragments

import android.content.Intent
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.activities.LoginActivity
import com.packagesayur.yursayur.adapter.ListSayurAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var rvSayur: RecyclerView
    private lateinit var rvBuah: RecyclerView
    private var list : ArrayList<SayurEntity> = arrayListOf()

    private lateinit var ivFotoProfile: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvSayur = view.findViewById(R.id.rvSayur)
        rvSayur.setHasFixedSize(true)

        rvBuah = view.findViewById(R.id.rvBuah)
        rvBuah.setHasFixedSize(true)
        ivFotoProfile = view.findViewById(R.id.ivFotoProfil)

        list.addAll(SayurData.listData)
        showRecyclerSayurList()
        showRecyclerBuahList()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun showRecyclerSayurList() {
        rvSayur.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listSayurAdapter = ListSayurAdapter(list)
        rvSayur.adapter = listSayurAdapter
    }

    private fun showRecyclerBuahList() {
        rvBuah.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val listSayurAdapter = ListSayurAdapter(list)
        rvBuah.adapter = listSayurAdapter
    }
}