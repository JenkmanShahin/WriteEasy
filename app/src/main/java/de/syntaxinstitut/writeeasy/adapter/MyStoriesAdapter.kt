package de.syntaxinstitut.writeeasy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.MystoriesListBinding

class MyStoriesAdapter(
    private val dataset: List<Story>
) : RecyclerView.Adapter<MyStoriesAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: MystoriesListBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = MystoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        val imgUri = item.photos.toUri().buildUpon().scheme("https").build()

        holder.binding.StoryImage.load(imgUri)
        holder.binding.TitleText.text = item.title

    }

    override fun getItemCount(): Int {
        return  dataset.size
    }
}