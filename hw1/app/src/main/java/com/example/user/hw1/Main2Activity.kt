package com.example.user.hw1



import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageButton


class Main2Activity : AppCompatActivity() {

    lateinit var button1: ImageButton
    lateinit var button2: ImageButton
    lateinit var button3: ImageButton
    lateinit var button4: ImageButton
    lateinit var button5: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.imageButton1)
        button2 = findViewById(R.id.imageButton2)
        button3 = findViewById(R.id.imageButton3)
        button4 = findViewById(R.id.imageButton4)
        button5 = findViewById(R.id.imageButton5)

        button1.setOnClickListener{
            val intent = Intent(this@Main2Activity, Activity1::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener{
            val intent = Intent(this@Main2Activity, Activity2::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener{
            val intent = Intent(this@Main2Activity, Activity3::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener{
            val intent = Intent(this@Main2Activity, Activity4::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener{
            val intent = Intent(this@Main2Activity, Activity5::class.java)
            startActivity(intent)
        }



    }

}



