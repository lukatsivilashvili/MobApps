package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler)

        val produclList = ArrayList<Product>()

        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )
        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )
        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )
        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )
        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )
        produclList.add(
            Product(
                1,
                "football",
                "american",
                R.drawable.ic_baseline_sports_football_24,
                true
            )
        )
        produclList.add(
            Product(
                2,
                "basketball",
                "global",
                R.drawable.ic_baseline_sports_basketball_24,
                true
            )
        )
        produclList.add(
            Product(
                3,
                "baseball",
                "american",
                R.drawable.ic_baseline_sports_baseball_24,
                true
            )
        )


        val adapter = productAdapter(produclList)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapter
    }
}