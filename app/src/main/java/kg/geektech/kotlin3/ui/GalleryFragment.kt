package kg.geektech.kotlin3.ui

import android.view.LayoutInflater
import android.view.View
import kg.geektech.kotlin3.R
import kg.geektech.kotlin3.adapters.ListAdapter
import kg.geektech.kotlin3.bases.BaseFragment
import kg.geektech.kotlin3.bases.BaseNavFragment
import kg.geektech.kotlin3.bases.BaseViewModel
import kg.geektech.kotlin3.databinding.FragmentGalleryBinding
import kg.geektech.kotlin3.interfaces.Click
import kg.geektech.kotlin3.models.Picture

class GalleryFragment : BaseNavFragment<FragmentGalleryBinding, BaseViewModel>(), Click {

    private var selectedList = arrayListOf<Picture>()
    private val list = arrayListOf(
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img),
        Picture("android.resource://kg.geektech.kotlin3/" +R.drawable.img)

    )

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentGalleryBinding {
        return FragmentGalleryBinding.inflate(inflater)
    }

    override fun initView()= with(binding) {
        recyclerView.adapter= ListAdapter(list, this@GalleryFragment)
    }

    override fun initListener() {
        binding.btnSend.setOnClickListener {
            val list1 = arrayListOf<String>()
            for (element in selectedList) {
                list1.add(element.uri)
            }
            val array: Array<String> = list1.toTypedArray()
            navigate(GalleryFragmentDirections.actionGalleryFragmentToSelectFragment(array))

        }
    }

    override fun choice(picture: Picture) {
        if (selectedList.contains(picture) && !picture.isSelect){
            selectedList.remove(picture)
        }else {
            selectedList.add(picture)
            binding.btnSend.visibility = View.VISIBLE

        }
    }

}