package de.syntaxinstitut.writeeasy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import de.syntaxinstitut.writeeasy.data.model.Story
import de.syntaxinstitut.writeeasy.databinding.FragmentStorydetailsBinding


class NewStoryAdapter(
    private val context: Context
) : RecyclerView.Adapter<NewStoryAdapter.ItemViewHolder>() {

    private lateinit var dataset: List<Story>

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<Story>) {
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
        val imgUri = item.photos.toUri().buildUpon().scheme("https").build()

        holder.binding.TitleText.text = item.title
        holder.binding.CoverFrame.load(imgUri)
        holder.binding.storyText.text = item.toString()

//        holder.binding.StoryFrame.setOnClickListener{
//            holder.itemView.findNavController()
//                .navigate(ProfileFragmentDirections.(item.toString()))
//        }
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
        }

