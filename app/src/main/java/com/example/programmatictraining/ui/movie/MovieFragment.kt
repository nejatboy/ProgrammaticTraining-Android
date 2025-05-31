package com.example.programmatictraining.ui.movie


import com.example.programmatictraining.R
import com.example.programmatictraining.base.BaseFragment


class MovieFragment: BaseFragment<MovieLayout, Nothing>() {


    override fun prepareLayout(): MovieLayout {
        return MovieLayout(context = requireContext())
    }


    override fun onViewCreate(layout: MovieLayout) {
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