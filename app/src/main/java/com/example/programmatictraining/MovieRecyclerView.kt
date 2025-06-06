package com.example.programmatictraining

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MovieRecyclerView(context: Context): RecyclerView(context) {

    val movieAdapter: MovieAdapter? get() = adapter as? MovieAdapter


    init {
        adapter = MovieAdapter()
        layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        setPadding(20)
    }
}



class MovieAdapter: RecyclerView.Adapter<MovieHolder>() {

    var movies = ArrayList<Movie>()
        set(value) {
            field = value
            notifyItemRangeChanged(0, value.size)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val row = MovieRow(context = parent.context)
        return MovieHolder(row)
    }


    override fun getItemCount(): Int {
        return movies.size
    }


    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        val movie = movies[position]
        holder.movieRow.setMovie(movie)
    }
}



class MovieHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val movieRow: MovieRow get() = itemView as MovieRow
}



class MovieRow(context: Context) : ConstraintLayout(context) {

    private val set = ConstraintSet()
    private val textViewName = TextView(context)
    private val imageView = ImageView(context)
    private val textViewDescription = TextView(context)


    init {
        val lp = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        lp.setMargins(40)

        val drawable = GradientDrawable()
        drawable.cornerRadius = 20f
        drawable.setColor(Color.WHITE)
        drawable.setStroke(2, Color.LTGRAY)

        layoutParams = lp
        background = drawable
        elevation = 20f

        setupViews()
        addViews()
        setupConstraints()
    }


    private fun setupViews() {
        textViewName.id = generateViewId()
        textViewName.typeface = Typeface.DEFAULT_BOLD
        textViewName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        textViewName.setTextColor(Color.BLACK)

        imageView.id = generateViewId()
        imageView.layoutParams = LayoutParams(LayoutParams.MATCH_CONSTRAINT, LayoutParams.MATCH_CONSTRAINT)

        textViewDescription.id = generateViewId()
        textViewDescription.layoutParams = LayoutParams(LayoutParams.MATCH_CONSTRAINT, LayoutParams.WRAP_CONTENT)
        textViewDescription.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16f)
        textViewDescription.setTextColor(Color.GRAY)
        textViewDescription.gravity = Gravity.CENTER
    }


    private fun addViews() {
        addView(textViewName)
        addView(imageView)
        addView(textViewDescription)
    }


    private fun setupConstraints() {
        set.clone(this)

        set.connect(textViewName.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 10)
        set.centerHorizontally(textViewName.id, ConstraintSet.PARENT_ID)

        set.connect(imageView.id, ConstraintSet.TOP, textViewName.id, ConstraintSet.BOTTOM, 20)
        set.centerHorizontally(imageView.id, ConstraintSet.PARENT_ID)
        set.setDimensionRatio(imageView.id, "16:9")
        set.constrainPercentWidth(imageView.id, 0.9f)

        set.connect(textViewDescription.id, ConstraintSet.TOP, imageView.id, ConstraintSet.BOTTOM)
        set.connect(textViewDescription.id, ConstraintSet.START, imageView.id, ConstraintSet.START)
        set.connect(textViewDescription.id, ConstraintSet.END, imageView.id, ConstraintSet.END)
        set.connect(textViewDescription.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 10)

        set.applyTo(this)
    }


    fun setMovie(movie: Movie) {
        imageView.setImageResource(movie.imageId)
        textViewName.text = movie.name
        textViewDescription.text = movie.description
    }
}
