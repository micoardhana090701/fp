package com.packagesayur.yursayur.notificationdata

import com.packagesayur.yursayur.R
import com.packagesayur.yursayur.data.sayurdata.SayurData
import com.packagesayur.yursayur.data.sayurdata.SayurEntity

object NotificationData {
    private val idNotification = arrayListOf(
        1,
        2,
        3,
    )

    private val titleNotification = arrayOf(
        "Selamat Anda Mendapatkan Promo Spesial!",
        "Belanja Lebih Murah Dengan Promo",
        "Belum gajian?. Tenang saja banyak promo yang tersedia"
    )

    private val descriptionnotification = arrayOf(
        "Sebagai pelanggan tetap anda mendapatkan promo diskon sebesar 30%",
        "Kini tersedia promo menarik dari kami, jangan lewatkan kesempatan ini sebelum tanggal 30 februari 2023",
        "Klaim promo sekarang dan dapatkan diskon sebesar 50% untuk pembelian pertama anda, promo berlaku sampai tanggal 1 november 2023"
    )
    private val timeNotification = arrayListOf(
        "13.43",
        "12.22",
        "18.11",
    )

    val listNotification: ArrayList<NotificationEntity>
        get() {
            val list = arrayListOf<NotificationEntity>()
            for(position in NotificationData.idNotification.indices){
                val notificationEntity = NotificationEntity()
                notificationEntity.idnotification = idNotification[position]
                notificationEntity.descriptionnotification = descriptionnotification[position]
                notificationEntity.titlenotification = titleNotification[position]
                notificationEntity.timenotification = timeNotification[position]
                list.add(notificationEntity)
            }
            return list
        }


}