package com.example.programmatictraining

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.ShapeAppearanceModel


class PokemonRecyclerView(context: Context): RecyclerView(context) {

    val pokemonAdapter: PokemonAdapter? get() = adapter as? PokemonAdapter


    init {
        adapter = PokemonAdapter()
        layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
        layoutParams = FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        setPadding(20)
    }
}



class PokemonAdapter: RecyclerView.Adapter<PokemonHolder>() {

    var pokemons = ArrayList<Pokemon>()
        set(value) {
            field = value
            notifyItemMoved(0, value.size - 1)
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        val row = PokemonCell(context = parent.context)
        return PokemonHolder(row)
    }


    override fun getItemCount(): Int {
        return pokemons.size
    }


    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val movie = pokemons[position]
        holder.pokemonCell.setMovie(movie)
    }
}



class PokemonHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val pokemonCell: PokemonCell get() = itemView as PokemonCell
}



class PokemonCell(context: Context) : ConstraintLayout(context) {

    private val set = ConstraintSet()
    private val textViewName = TextView(context)
    private val imageView = ShapeableImageView(context)


    init {
        val lp = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        lp.setMargins(20)

        val drawable = GradientDrawable()
        drawable.cornerRadius = 40f
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
        imageView.scaleType = ImageView.ScaleType.FIT_XY
        imageView.shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(40f)
    }


    private fun addViews() {
        addView(textViewName)
        addView(imageView)
    }


    private fun setupConstraints() {
        set.clone(this)

        set.connect(textViewName.id, ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 20)
        set.centerHorizontally(textViewName.id, ConstraintSet.PARENT_ID)

        set.connect(imageView.id, ConstraintSet.TOP, textViewName.id, ConstraintSet.BOTTOM, 20)
        set.connect(imageView.id, ConstraintSet.START, ConstraintSet.PARENT_ID, ConstraintSet.START, 20)
        set.connect(imageView.id, ConstraintSet.END, ConstraintSet.PARENT_ID, ConstraintSet.END, 20)
        set.connect(imageView.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 20)
        set.setDimensionRatio(imageView.id, "3:4")

        set.applyTo(this)
    }


    fun setMovie(pokemon: Pokemon) {
        imageView.setImageResource(pokemon.imageId)
        textViewName.text = pokemon.name
    }
}