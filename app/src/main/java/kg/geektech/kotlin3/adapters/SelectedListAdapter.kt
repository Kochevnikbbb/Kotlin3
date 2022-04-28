package kg.geektech.kotlin3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.geektech.kotlin3.R
import kg.geektech.kotlin3.databinding.ItemListBinding

class SelectedListAdapter(private var list: ArrayList<String>) : RecyclerView.Adapter<
        SelectedListAdapter.ImageHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ImageHolder(view)
    }

    override fun onBindViewHolder(holder: ImageHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount()=list.size

    class ImageHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val binding= ItemListBinding.bind(itemView)
        fun bind(history: String) = with(binding){
            Glide.with(binding.root).load(history).into(ivImage)
        }
    }
}