package de.syntaxinstitut.writeeasy.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.AlreadyreadListBinding

class AlreadyReadAdapter(
    private val dataset: List<Story>
) : RecyclerView.Adapter<AlreadyReadAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: AlreadyreadListBinding) :
            RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = AlreadyreadListBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        Log.i("AlreadyReadAdapter", item.title)
        holder.binding.KidsStoryImage.setImageResource(item.image)
        holder.binding.TitleandText.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}