package com.example.assignmentrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.recycler)

        val urlList = ArrayList<Images>()


        urlList.add(Images("https://img-9gag-fun.9cache.com/photo/aGZwpmK_460s.jpg", "Mazda RX-7 Veilside Kit"))
        urlList.add(Images("https://i.pinimg.com/originals/d7/af/e7/d7afe7d1184f162571a7b5fba40848f4.jpg", "Toytota Supra - \"Black Widow\" "))
        urlList.add(Images("https://i.pinimg.com/736x/76/76/56/767656239266a25967caf65326699aeb.jpg", "Nissan GT-R R35 - Brian O'Conner "))
        urlList.add(Images("https://img.hmn.com/fit-in/450x253/filters:upscale()/stories/2018/08/342111.jpg", "1969 Dodge Charger"))
        urlList.add(Images("https://bringatrailer.com/wp-content/uploads/2019/01/2009_lamborghini_murcielago_15475883543ada4d93c1Murcielago-01715.jpg?fit=940%2C584", "Lamborghini Murcielago"))
        urlList.add(Images("https://i.pinimg.com/originals/ff/df/05/ffdf05d5f0962b490fdebf36e28f9f99.jpg", "Nissan Silvia S14 240SX - Rocket Bunny Kit"))
        urlList.add(Images("https://www.theengineblock.com/wp-content/uploads/2017/05/2015-lexus-rc-350-rocket-bunny.jpg", "Lexus RC F Sport - Rocket Bunny Kit"))
        urlList.add(Images("https://image.nengun.com/catalogue/1024x768/nengun-4059-09-greddy-rocket_bunny_aero_kit_wide_version_-_86_brz-abbcc044.png", "Scion FR-S - Rocket Bunny Kit"))
        urlList.add(Images("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ3F3WlWiy9iI_rJ0Qt1G9PzAOZ37p5iCqFZA&usqp=CAU", "Mercedes Benz CLS - W218"))
        urlList.add(Images("https://mercedesblog.com/wp-content/uploads/2020/06/Mercedes-Benz-G63-AMG-6x6-14.jpg", "Mercedes Benz G63 - 6X6"))
        urlList.add(Images("https://i.ytimg.com/vi/TQ-yjBqALis/maxresdefault.jpg", "Lamborghini Urus"))
        urlList.add(Images("https://www.carscoops.com/wp-content/uploads/2019/01/bf12290d-ferrari-812-superfast-tuning-novitec-0.jpg", "Ferrari 812 Superfast"))
        urlList.add(Images("https://s3-prod.autonews.com/s3fs-public/CULLINANBLACKBADGE-MAIN_i.jpg", "Rolls Royce Cullinan"))
        urlList.add(Images("https://api.ferrarinetwork.ferrari.com/v2/network-content/medias/resize/5dc04886900e4a3e9ebbb415-ferrari-fxx-2005-share?apikey=9QscUiwr5n0NhOuQb463QEKghPrVlpaF&width=1080", "Ferrari FXX"))
        urlList.add(Images("https://static.wikia.nocookie.net/gran-turismo/images/1/1c/Aston_Martin_Vulcan_%2716.jpg/revision/latest?cb=20181204095601", "Aston Martin Vulkan"))
        urlList.add(Images("https://www.alainclass.com/wp-content/uploads/2020/04/2006-Mercedes-Benz-SLR-McLaren-By-Fab-Design-WHITE-007173.jpg", "Mercedes Benz SLR Mclaren"))

        val adapter = imageAdapter(urlList, this)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter

    }
}