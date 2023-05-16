package com.packagesayur.yursayur.data.sayurdata

import com.packagesayur.yursayur.R

object SayurData{

    private val idSayur = arrayListOf(
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

    private val sayurImage = arrayOf(
        R.drawable.img,
        R.drawable.img_1,
        R.drawable.img_2,
        R.drawable.img_3,
        R.drawable.img_4,
        R.drawable.img_5,
        R.drawable.img_6,
        R.drawable.img_7,
        R.drawable.img_8,
        R.drawable.img_9,
    )

    private val namaSayur = arrayOf(
        "Terong",
        "Tomat",
        "Wortel",
        "Bawang Bombay",
        "Kubis",
        "Jagung Manis",
        "Bunga Kol",
        "Seledri",
        "Daun Bawang",
        "Bayam",
    )

    private val rateSayur = arrayOf(
        4.4,
        4.3,
        4.9,
        4.8,
        4.8,
        4.3,
        4.1,
        4.7,
        4.3,
        4.6,
    )

    private val peopleSayur = arrayOf(
        2038,
        1238,
        3038,
        1038,
        4538,
        2438,
        2438,
        2438,
        2438,
        2438,
    )

    private val hargaSayur = arrayOf(
        4000,
        3000,
        3500,
        5000,
        2000,
        2000,
        4000,
        4000,
        5000,
        4000,
        2000
    )

    private val deskripsiSayur = arrayOf(
        "sayur terong ungu memiliki berat 250g, dipanen langsung dari kebun. memiliki manfaat:\n" +
                "- menurunkan kolesterol\n" +
                "- meningkatkan kesehatan tulang\n" +
                "- menurunkan berat badan",
        "sayur tomat merah segar. memiliki manfaat:\n" +
                "- mengurangi resiko kanker\n" +
                "- menurunkan dan mengontrol tekanan darah\n" +
                "- mengontrol kadar gula darah",
        "wortel segar yang dipanen langsung dari kebun. bermanfaat sebagai antioksidan serta meningkatkan penglihatan konsumen",
        "bawang bombay adalah sayuran yang kaya akan vitamin c, bermanfaat untuk menyehatkan kulit dan rambut",
        "sayur kubis, bermanfaat bagi mereka yang ingin menurunkan tekanan darah dan kolesterol. dipanen langsung dari kebun petani.",
        "tersedia dalam kemasan 1kg, yursayur menyediakan jagung segar manis dengan manfaat:\n" +
                "- meningkatkan kepadatan tulang\n" +
                "- melancarkan saluran pencernaan\n" +
                "- baik untuk kesehatan jantung",
        "sayuran kembang kol bermanfaat untuk mengobati sariawan, batuk berdahak, dan cacar air",
        "sayuran yang berada dalam kemasan 500gr ini memiliki manfaat sebagai berikut:\n" +
                "- mencegah peradangan\n" +
                "- mencegah dehidrasi\n" +
                "- menurunkan kadar kolesterol",
        "dibungkus dalam kemasan 500gr. bermanfaat sebagai pencegah anemia, mengatasi asma, dan mencegah penyakit jantung",
        "sayur bayam dengan kemasan 250gr. bermanfaat sebagai penyegah kanker, memperkuat otot, dan menjaga tekanan darah",
    )
    private val gambartoko = arrayOf(
        R.drawable.img_11,
        R.drawable.img_12,
        R.drawable.img_13,
        R.drawable.img_11,
        R.drawable.img_14,
        R.drawable.img_15,
        R.drawable.img_11,
        R.drawable.img_15,
        R.drawable.img_14,
        R.drawable.img_13,
    )
    private val tokoSayur = arrayOf(
        "Sayur Makmur Bantul",
        "Jaya Grocery",
        "Mugi Makmur",
        "Sejahtera Mart",
        "Sigit Sayur",
        "Sayur Segar",
        "Hijau Sehat",
        "Vegetarian Grocery",
        "Subur Jaya",
        "Vegetarian Grocery"
    )
    private val lokasiToko = arrayOf(
        "Sleman, DIY",
        "Mertoyudan, Magelang",
        "Madukara, Banjarnegara",
        "Bantul, DIY",
        "Gunung Kidul, DIY",
        "Sleman, DIY",
        "Mertoyudan, Magelang",
        "Madukara, Banjarnegara",
        "Bantul, DIY",
        "Gunung Kidul, DIY",
    )

    private val statusesToko = arrayOf(
        "online",
        "online",
        "online",
        "online",
        "online",
        "online",
        "offline",
        "offline",
        "offline",
        "offline",
    )

    val listData: ArrayList<SayurEntity>
        get() {
            val list = arrayListOf<SayurEntity>()
            for(position in idSayur.indices){
                val sayurEntity = SayurEntity()
                sayurEntity.id = idSayur[position]
                sayurEntity.gambar = sayurImage[position]
                sayurEntity.nama = namaSayur[position]
                sayurEntity.rate = rateSayur[position]
                sayurEntity.people = peopleSayur[position]
                sayurEntity.harga = hargaSayur[position]
                sayurEntity.deskripsi = deskripsiSayur[position]
                sayurEntity.gambartoko = gambartoko[position]
                sayurEntity.toko = tokoSayur[position]
                sayurEntity.lokasi = lokasiToko[position]
                sayurEntity.statuses = statusesToko[position]
                list.add(sayurEntity)
            }
            return list
        }
}