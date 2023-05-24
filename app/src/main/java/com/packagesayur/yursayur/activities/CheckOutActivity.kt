package com.packagesayur.yursayur.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.adapter.CartSayurAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity
import com.packagesayur.yursayur.fragments.HomeFragment

class CheckOutActivity : AppCompatActivity() {

    private lateinit var rvCheckout : RecyclerView
    private lateinit var btnCheckout : Button
    private var list : ArrayList<SayurEntity> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        btnCheckout = findViewById(R.id.btnPesan)
        rvCheckout = findViewById(R.id.rvCheckOut)
        rvCheckout.setHasFixedSize(true)
        list.addAll(SayurData.listData)
        btnCheckout.setOnClickListener {
            showConfirmationDialog()
        }
        showCartList()
    }
    private fun showConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle("Konfirmasi")
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin melanjutkan?")

        alertDialogBuilder.setPositiveButton("Ya") { dialog, which ->
            startActivity(Intent(this, EndTransactionActivity::class.java))
        }

        alertDialogBuilder.setNegativeButton("Tidak") { dialog, which ->
            dialog.dismiss()
            finish()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
    private fun showCartList() {
        rvCheckout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val listSayurAdapter = CartSayurAdapter(list)
        rvCheckout.adapter = listSayurAdapter
    }
}