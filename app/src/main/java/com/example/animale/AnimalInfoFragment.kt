package com.example.animale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.animale.R

class AnimalInfoFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.animalinfo_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nameTextView = view.findViewById<TextView>(R.id.AnimalName)
        val continentTextView = view.findViewById<TextView>(R.id.AnimalContinent)

        val args = arguments
        if (args != null) {
            val animalName = args.getString("animalName")
            val animalContinent = args.getString("animalContinent")
            val animalColor = args.getInt("continentColor")

            nameTextView.text = animalName
            continentTextView.text = animalContinent

            view.setBackgroundColor(animalColor)
            }
        }
}
