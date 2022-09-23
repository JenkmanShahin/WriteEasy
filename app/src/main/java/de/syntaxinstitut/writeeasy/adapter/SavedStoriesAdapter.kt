package de.syntaxinstitut.writeeasy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.AllstoriesListBinding

class SavedStoriesAdapter(
    private val dataset: List<Story>
) : RecyclerView.Adapter<SavedStoriesAdapter.ItemViewHolder>() {


    class ItemViewHolder(val binding: AllstoriesListBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding =
            AllstoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        Log.i("SavedAdapter", item.title)
      //  holder.binding.StoryImage.setImageResource(item.photos)
        holder.binding.TitleText.text = item.title
        holder.binding.DescritionText.text = item.description
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}