package com.packagesayur.yursayur.chatdata

import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

object ChatData {

    private val idChat = arrayListOf(
        1,
        2,
        3,
        4,
        5,
        6,
        7,
        8,
        9,
        10
    )

    private val chatImage = arrayOf(
        R.drawable.img,
        R.drawable.img_11,
        R.drawable.img_12,
        R.drawable.img_13,
        R.drawable.img_14,
        R.drawable.img_15,
        R.drawable.img_16,
        R.drawable.img_15,
        R.drawable.img_12,
        R.drawable.img_14,
    )

    private val namaChat = arrayOf(
        "Karya Mandiri",
        "Petani Handal",
        "PDI Perjuangan",
        "Sido Muncul",
        "Sido Makmur",
        "Gapoktan Desa Penari",
        "Jaya Makmur",
        "Utama Maju",
        "Mundur Terus",
        "Sumber Abadi",
    )

    private val jamChat = arrayOf(
        20.34,
        12.38,
        10.38,
        10.38,
        15.12,
        14.42,
        14.00,
        18.38,
        20.11,
        12.00,
    )


    private val deskripsiChat = arrayOf(
        "hallo apakah produk ini tersedia?",
        "boleh turun harga ga?",
        "jangan lupa tagihannya kak....",
        "apakah masih?",
        "mantap nih toko",
        "terima kasih kak",
        "jangan lupa ratingnya ya",
        "kurang suka sih kak",
        "kami kasih bonus kak",
        "apakah ada jengkol?"
    )

    val listChatData: ArrayList<ChatEntity>
        get() {
            val list = arrayListOf<ChatEntity>()
            for (position in idChat.indices) {
                val chatEntity = ChatEntity()
                chatEntity.idchat = idChat[position]
                chatEntity.gambarchat = chatImage[position]
                chatEntity.namachat = namaChat[position]
                chatEntity.deskripsichat = deskripsiChat[position]
                chatEntity.jamchat = jamChat[position]
                list.add(chatEntity)
            }
            return list
        }
}