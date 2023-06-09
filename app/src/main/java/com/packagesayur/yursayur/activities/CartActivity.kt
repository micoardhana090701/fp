package com.packagesayur.yursayur.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.adapter.CartSayurAdapter
import com.packagesayur.yursayur.adapter.ListSayurAdapter
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

class CartActivity : AppCompatActivity() {

    private lateinit var rvCart : RecyclerView
    private lateinit var btnCheckout : Button
    private var list : ArrayList<SayurEntity> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        btnCheckout = findViewById(R.id.btnCheckout)
        rvCart = findViewById(R.id.rvCart)
        rvCart.setHasFixedSize(true)
        list.addAll(SayurData.listData)
        showCartList()
        btnCheckout.setOnClickListener {
            showConfirmationDialog()
        }
    }

    private fun showConfirmationDialog() {
        val alertDialogBuilder = AlertDialog.Builder(this)

        alertDialogBuilder.setTitle("Konfirmasi")
        alertDialogBuilder.setMessage("Apakah Anda yakin ingin melanjutkan?")

        alertDialogBuilder.setPositiveButton("Ya") { dialog, which ->
            startActivity(Intent(this, CheckOutActivity::class.java))
        }

        alertDialogBuilder.setNegativeButton("Tidak") { dialog, which ->
            dialog.dismiss()
            finish()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun showCartList() {
        rvCart.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val listSayurAdapter = CartSayurAdapter(list)
        rvCart.adapter = listSayurAdapter
    }
}