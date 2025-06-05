package com.example.programmatictraining

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    private lateinit var layout: MainLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        layout = MainLayout(context = this)
        setContentView(layout)
        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(layout) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setData()
    }


    private fun setData() {
        val movies = arrayListOf(
            Movie(name = "Gladyator", imageId = R.drawable.gladyator, description = "A former Roman General sets out to exact vengeance against the corrupt emperor who murdered his family and sent him into slavery."),
            Movie(name = "Inception", imageId = R.drawable.inception, description = "Cobb steals information from his targets by entering their dreams."),
            Movie(name = "Just Mercy", imageId = R.drawable.just_mercy, description = "Attorney Bryan Stevenson fights the case of a man who is wrongfully convicted of committing murder and is sentenced to death by electrocution."),
            Movie(name = "Oppenhemimer", imageId = R.drawable.oppenheimer, description = "J. Robert Oppenheimer was an American theoretical physicist who served as the director of the Manhattan Project's Los Alamos Laboratory during World War II."),
            Movie(name = "Scarface", imageId = R.drawable.scarface, description = "Tony Montana and his close friend Manny, build a strong drug empire in Miami."),
            Movie(name = "Shooter", imageId = R.drawable.shooter, description = "Bob Lee Swagger, one of the world's greatest marksman, lives alone in the Rockies."),
        )

        layout.recyclerView.movieAdapter?.movies = movies
    }
}