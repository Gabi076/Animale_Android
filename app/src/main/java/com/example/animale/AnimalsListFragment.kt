package com.example.animale.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.animale.adapters.AnimalAdapter
import com.example.animale.models.Animal
import com.example.animale.R

class AnimalListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AnimalAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.animalslist_fragment, container, false)

        val animalList = generateAnimalList()
        adapter = AnimalAdapter(animalList)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

    private fun generateAnimalList(): List<Animal> {
        val animals = listOf(
            Animal("Elephant", "Africa"),
            Animal("Panda", "Asia"),
            Animal("Kangaroo", "Australia"),
            Animal("Penguin", "Antarctica"),
            Animal("Fox", "Europe"),
            Animal("Grizzly Bear", "North America"),
            Animal("Jaguar", "South America")
        )

        val random = java.util.Random()
        val animalList = mutableListOf<Animal>()
        animalList.addAll(animals)

        // Generate 50 Animal objects by randomly selecting from the given list
        repeat(43) {
            val randomAnimal = animals[random.nextInt(animals.size)]
            animalList.add(randomAnimal)
        }

        return animalList
    }
}
