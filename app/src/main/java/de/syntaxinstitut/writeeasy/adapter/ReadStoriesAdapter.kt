package de.syntaxinstitut.writeeasy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.writeeasy.data.model.ReadStories
import de.syntaxinstitut.writeeasy.databinding.ReadListBinding

class ReadStoriesAdapter(
    private val dataset: List<ReadStories>
) : RecyclerView.Adapter<ReadStoriesAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: ReadListBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = ReadListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]


        holder.binding.ReadImage.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}