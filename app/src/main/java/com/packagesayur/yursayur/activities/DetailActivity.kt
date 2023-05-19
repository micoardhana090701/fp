package com.packagesayur.yursayur.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.adapter.TanggapanAdapter
import com.packagesayur.yursayur.data.sayurdata.Message
import java.util.Date

class DetailActivity : AppCompatActivity() {
    companion object{
        const val MESSAGES_CHILD = "messages"
        const val EXTRA_IMAGE = "extra_image"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_RATE = "extra_rate"
        const val EXTRA_PEOPLE = "extra_people"
        const val EXTRA_HARGA = "extra_harga"
        const val EXTRA_DESKRIPSI = "extra_deskripsi"
        const val EXTRA_IMAGETOKO = "extra_imagetoko"
        const val EXTRA_TOKO = "extra_toko"
        const val EXTRA_STATUSES = "extra_statuses"
        const val EXTRA_LOKASI = "extra_lokasi"
    }

    private lateinit var ivSayurDetail: ImageView
    private lateinit var tvNamaDetail: TextView
    private lateinit var tvRateDetail: TextView
    private lateinit var tvPeopleDetail: TextView
    private lateinit var tvHargaDetail: TextView
    private lateinit var tvDeskripsiDetail: TextView
    private lateinit var ivGambarToko: ImageView
    private lateinit var tvNamaToko: TextView
    private lateinit var tvStatus: TextView
    private lateinit var tvLokasi: TextView
    private lateinit var btnBackToHome: ImageView
    private lateinit var tvChat: TextView
    private lateinit var btnKunjungi: Button
    private lateinit var etPesan: EditText
    private lateinit var db: FirebaseDatabase
    private lateinit var adapter: TanggapanAdapter
    private lateinit var sendButton: ImageView
    private lateinit var auth: FirebaseAuth
    private lateinit var rvTanggapan : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.hide()
        auth = FirebaseAuth.getInstance()
        val firebaseUser = auth.currentUser

        if (firebaseUser == null) {
            // Not signed in, launch the Login activity
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        ivSayurDetail = findViewById(R.id.ivSayurDetail)
        tvNamaDetail = findViewById(R.id.tvNamaSayurDetail)
        tvRateDetail = findViewById(R.id.tvRateDetail)
        tvPeopleDetail = findViewById(R.id.tvPeopleDetail)
        tvHargaDetail = findViewById(R.id.tvHargaDetail)
        tvDeskripsiDetail = findViewById(R.id.tvDeskripsiDetail)
        ivGambarToko = findViewById(R.id.ivGambarToko)
        tvNamaToko = findViewById(R.id.tvNamaToko)
        tvStatus = findViewById(R.id.tvStatus)
        tvLokasi = findViewById(R.id.tvLokasi)
        etPesan = findViewById(R.id.messageEditText)
        btnBackToHome = findViewById(R.id.btnBackToHome)
        tvChat = findViewById(R.id.tvHubungiPenjual)
        btnKunjungi = findViewById(R.id.btnKunjungi)
        sendButton = findViewById(R.id.sendButton)
        rvTanggapan = findViewById(R.id.rvTanggapan)

        db = Firebase.database


        loadDetail()

        btnBackToHome.setOnClickListener{
            finish()
        }
        tvChat.setOnClickListener{
            val btnchat = Intent(this, ChatActivity::class.java)
            startActivity(btnchat)
        }
        btnKunjungi.setOnClickListener{
            startActivity(Intent(this, TokoActivity::class.java))
        }

        val messegesRef = db.reference.child(MESSAGES_CHILD)

        sendButton.setOnClickListener{
            val friendlyMessage = Message(
                etPesan.text.toString(),
                firebaseUser.email.toString(),
                Date().time
            )
            messegesRef.push().setValue(friendlyMessage){error, _ ->
                if (error !=null){
                    Toast.makeText(this, "Gagal Terkirim", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "Berhasil Terkirim", Toast.LENGTH_SHORT).show()
                }
            }
            etPesan.setText("")
        }

        rvTanggapan.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val options = FirebaseRecyclerOptions.Builder<Message>()
            .setQuery(messegesRef, Message::class.java)
            .build()
        adapter = TanggapanAdapter(options, firebaseUser?.email)
        rvTanggapan.adapter = adapter
    }

    private fun loadDetail() {
        val setIvGambar = intent.getStringExtra(EXTRA_IMAGE)
        val setNamaSayur = intent.getStringExtra(EXTRA_NAME)
        val setRate = intent.getStringExtra(EXTRA_RATE)
        val setPeople = intent.getStringExtra(EXTRA_PEOPLE)
        val setHarga = intent.getStringExtra(EXTRA_HARGA)
        val setDeskripsi = intent.getStringExtra(EXTRA_DESKRIPSI)
        val setIvGambarToko = intent.getStringExtra(EXTRA_IMAGETOKO)
        val setNamaToko = intent.getStringExtra(EXTRA_TOKO)
        val setStatuses = intent.getStringExtra(EXTRA_STATUSES)
        val setLokasi = intent.getStringExtra(EXTRA_LOKASI)

        if (setIvGambar != null) {
            Glide.with(this)
                .load(setIvGambar.toInt())
                .apply(RequestOptions())
                .into(ivSayurDetail)
        }

        tvNamaDetail.text = setNamaSayur
        tvRateDetail.text = setRate
        tvPeopleDetail.text = setPeople
        tvHargaDetail.text = setHarga
        tvDeskripsiDetail.text = setDeskripsi
        if(setIvGambarToko != null){
            Glide.with(this)
                .load(setIvGambarToko.toInt())
                .apply(RequestOptions())
                .into(ivGambarToko)
        }
        tvNamaToko.text = setNamaToko
        tvStatus.text = setStatuses
        tvLokasi.text = setLokasi
    }
    public override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    public override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

}