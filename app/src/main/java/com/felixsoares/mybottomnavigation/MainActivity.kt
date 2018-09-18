package com.felixsoares.mybottomnavigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.felixsoares.mybottomnavy.BottomNavy
import com.felixsoares.mybottomnavy.ItemNavy
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), BottomNavy.OnTabSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavy
                .addItem(ItemNavy(R.drawable.home, R.drawable.home_h, hasBadge = true))
                .addItem(ItemNavy(R.drawable.discover, R.drawable.discover_h))
                .addItem(ItemNavy(R.drawable.atividade, R.drawable.atividade_h, hasAlert = true))
                .addItem(ItemNavy(R.drawable.perfil, R.drawable.perfil_h))
                .build(this)

        btnAlert.setOnClickListener {
            bottomNavy.showAlert()
        }

        btnAlert2.setOnClickListener {
            bottomNavy.hideAlert()
        }

        btnBadge.setOnClickListener {
            bottomNavy.addBadge(Random().nextInt(99))
        }
    }

    override fun onTabSelected(position: Int) {
        Toast.makeText(this, "Position $position", Toast.LENGTH_SHORT).show()
    }

}
