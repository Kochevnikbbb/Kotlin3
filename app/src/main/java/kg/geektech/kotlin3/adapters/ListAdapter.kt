package kg.geektech.kotlin3.adapters

import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.kotlin3.R
import kg.geektech.kotlin3.databinding.FragmentGalleryBinding
import kg.geektech.kotlin3.databinding.ItemListBinding
import kg.geektech.kotlin3.interfaces.Click
import kg.geektech.kotlin3.models.Picture
import kg.geektech.kotlin3.ui.GalleryFragment


class ListAdapter(
    private var list: ArrayList<Picture>,
    private var choiceTap: GalleryFragment
) : RecyclerView.Adapter<ListAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        val picture = list[position]
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            picture.isSelect = !picture.isSelect
            choiceTap.choice(picture)
            holder.sel(picture)
        }
    }

    override fun getItemCount() = list.size

    class ImageHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListBinding.bind(itemView)
        fun bind(history: Picture) = with(binding) {
            Glide.with(binding.root).load(history.uri).into(ivImage)
            if (history.isSelect) {
                ivImage.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                ivImage.clearColorFilter()
            }
        }

        fun sel(picture: Picture) {
            if (picture.isSelect) {
                binding.ivImage.setColorFilter(R.color.black, PorterDuff.Mode.DARKEN)
            } else {
                binding.ivImage.clearColorFilter()
            }
        }
    }
}