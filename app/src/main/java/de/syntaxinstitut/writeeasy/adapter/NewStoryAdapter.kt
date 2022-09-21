package de.syntaxinstitut.writeeasy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.writeeasy.data.model.ReadStories
import de.syntaxinstitut.writeeasy.databinding.FragmentStorydetailsBinding
import de.syntaxinstitut.writeeasy.ui.ui.ProfileFragmentDirections


class NewStoryAdapter(
    private val context: Context
) : RecyclerView.Adapter<NewStoryAdapter.ItemViewHolder>() {

    private lateinit var dataset: List<ReadStories>

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ReadStories>) {
        dataset = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(val binding: FragmentStorydetailsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val binding = FragmentStorydetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ItemViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        Log.i("NewStoryAdapter", item.toString())
        holder.binding.TitleText.text = item.title
        holder.binding.CoverFrame.setImageResource(item.image)
        holder.binding.storyText.text = item.toString()

        holder.binding.StoryFrame.setOnClickListener{
            holder.itemView.findNavController()
                .navigate(ProfileFragmentDirections.actionProfileKidsFragmentToStoryShowKidsFragment(item.toString()))
        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
        }

