package de.syntaxinstitut.writeeasy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.writeeasy.data.model.MyStories
import de.syntaxinstitut.writeeasy.databinding.MystoriesListBinding

class MyStoriesAdapter(
    private val dataset: List<MyStories>
) : RecyclerView.Adapter<MyStoriesAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: MystoriesListBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = MystoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        Log.i("MyStoriesAdapter", item.Title)
        holder.binding.imageStory.setImageResource(item.Image)

    }

    override fun getItemCount(): Int {
        return  dataset.size
    }
}