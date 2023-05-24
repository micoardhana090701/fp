package com.packagesayur.yursayur.fragments

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.adapter.ListSayurAdapter
import com.packagesayur.yursayur.adapter.NotificationAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurEntity
import com.packagesayur.yursayur.notificationdata.NotificationData
import com.packagesayur.yursayur.notificationdata.NotificationEntity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var rvNotification: RecyclerView
    private var list : ArrayList<NotificationEntity> = arrayListOf()

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
        return inflater.inflate(R.layout.fragment_notification, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNotification = view.findViewById(R.id.rvNotification)
        rvNotification.setHasFixedSize(true)

        list.addAll(NotificationData.listNotification)
        showRecyclerNotification()
    }

    private fun showRecyclerNotification() {
        rvNotification.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val notificationAdapter = NotificationAdapter(list)
        rvNotification.adapter = notificationAdapter
    }
}