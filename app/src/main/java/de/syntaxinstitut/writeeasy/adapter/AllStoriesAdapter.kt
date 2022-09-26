package de.syntaxinstitut.writeeasy.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.AllstoriesListBinding
import de.syntaxinstitut.writeeasy.ui.ui.HomeFragmentDirections


class AllStoriesAdapter(
    private val addreadStories: (Story) -> Unit
) : RecyclerView.Adapter<AllStoriesAdapter.ItemViewHolder>() {

    private var dataset: List<Story> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Story>) {
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

        holder.binding.StoryImage.load(imgUri)

        holder.binding.TitleText.text = item.title
        holder.binding.DescritionText.text = item.description


        holder.binding.cardView2.setOnClickListener{
            holder.itemView.findNavController().navigate(HomeFragmentDirections.actionHomeKidsFragmentToStoryShowKidsFragment(item.ids))
            addreadStories(item)
        }
    }


    
    override fun getItemCount(): Int {
        return dataset.size
    }
}
