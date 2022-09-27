package de.syntaxinstitut.writeeasy.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.ReadListBinding

class ReadStoriesAdapter(
) : RecyclerView.Adapter<ReadStoriesAdapter.ItemViewHolder>() {

    private var dataset: List<Story> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Story>) {
        dataset = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: ReadListBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = ReadListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        if (!item.read){
            holder.binding.ReadImage.load(null)
            return
        }

        val imgUri = item.photos.toUri().buildUpon().scheme("https").build()
        holder.binding.ReadImage.load(imgUri)

        holder.binding.TitleText.text = item.title
        holder.binding.NameText.text = item.personName


    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}