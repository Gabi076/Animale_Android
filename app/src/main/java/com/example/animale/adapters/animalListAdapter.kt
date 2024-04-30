package com.example.animale.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.animale.models.Animal
import com.example.animale.R
import com.example.animale.fragments.AnimalInfoFragment
import com.example.animale.fragments.AnimalListFragmentDirections

class AnimalAdapter(private val animalList: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val animalName: TextView = itemView.findViewById(R.id.animal_name)
        val animalContinent: TextView = itemView.findViewById(R.id.animal_continent)
    }

    override fun getItemCount(): Int {
        return animalList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.animal_item, parent, false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val currentAnimal = animalList[position]
        holder.animalName.text = currentAnimal.name
        holder.animalContinent.text = currentAnimal.continent
        holder.itemView.setBackgroundColor(currentAnimal.color.toInt())

        val textColor = when (currentAnimal.continent) {
            "Africa", "South America" -> R.color.black
            else -> android.R.color.white
        }
        holder.animalName.setTextColor(holder.itemView.context.getColor(textColor))
        holder.animalContinent.setTextColor(holder.itemView.context.getColor(textColor))

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val fragment = AnimalInfoFragment()
            val args = Bundle()
            args.putString("animalName", currentAnimal.name)
            args.putString("animalContinent", currentAnimal.continent)
            args.putInt("continentColor", currentAnimal.color.toInt())
            fragment.arguments=args
            (context as AppCompatActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.info_container, fragment)
                .addToBackStack(null)
                .commit()
    }

}}