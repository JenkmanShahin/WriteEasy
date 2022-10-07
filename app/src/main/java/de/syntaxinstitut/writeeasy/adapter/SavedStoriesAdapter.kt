package de.syntaxinstitut.writeeasy.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.AllstoriesListBinding

class SavedStoriesAdapter(
) : RecyclerView.Adapter<SavedStoriesAdapter.ItemViewHolder>() {

    private var dataset: List<Story> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Story>) {
//        var savedList = mutableListOf<Story>()
//        for (story in list) {
//            if (story.saved == true) {
//                savedList.add(story)
//            }
//        }
        dataset = list
        notifyDataSetChanged()
    }


    class ItemViewHolder(val binding: AllstoriesListBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding =
            AllstoriesListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]
        val imgUri = item.photos.toUri().buildUpon().scheme("https").build()



        holder.binding.TitleText.text = item.title
        holder.binding.StoryImage.load(imgUri)
        holder.binding.DescritionText.text = item.description
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}