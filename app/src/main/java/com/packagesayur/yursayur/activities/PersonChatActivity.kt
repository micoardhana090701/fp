package com.packagesayur.yursayur.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.packagesayur.yursayur.R

class PersonChatActivity : AppCompatActivity() {

    private lateinit var ivProfilePerson: ImageView
    private lateinit var btnBack: ImageView
    private lateinit var tvNamePerson: TextView
    private lateinit var tvTimePerson: TextView
    private lateinit var tvDescriptionPerson: TextView

    companion object{
        const val EXTRA_IMAGE_CHAT = "extra_image_chat"
        const val EXTRA_NAME_CHAT = "extra_name_chat"
        const val EXTRA_TIME_CHAT = "extra_time_chat"
        const val EXTRA_DESCRIPTION_CHAT = "extra_people_chat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_chat)

        ivProfilePerson = findViewById(R.id.ivProfilePerson)
        btnBack = findViewById(R.id.btnBackToHome3)
        tvNamePerson = findViewById(R.id.tvNamaPerson)
        tvTimePerson = findViewById(R.id.tvTimePerson)
        tvDescriptionPerson = findViewById(R.id.tvDeskripsiChatPerson)
        btnBack.setOnClickListener{
            finish()
        }

        loadChat()
    }

    private fun loadChat(){
        val setIvProfile = intent.getStringExtra(EXTRA_IMAGE_CHAT)
        val setTvName = intent.getStringExtra(EXTRA_NAME_CHAT)
        val setTvTime = intent.getStringExtra(EXTRA_TIME_CHAT)
        val setTvDescription = intent.getStringExtra(EXTRA_DESCRIPTION_CHAT)
        if (setIvProfile != null){
            Glide.with(this)
                .load(setIvProfile.toInt())
                .apply(RequestOptions())
                .into(ivProfilePerson)
        }
        tvNamePerson.text = setTvName
        tvTimePerson.text = setTvTime
        tvDescriptionPerson.text = setTvDescription
    }
}