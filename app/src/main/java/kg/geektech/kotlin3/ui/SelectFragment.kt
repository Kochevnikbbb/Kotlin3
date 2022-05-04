package kg.geektech.kotlin3.ui

import android.os.Bundle
import android.view.LayoutInflater
import kg.geektech.kotlin3.adapters.SelectedListAdapter
import kg.geektech.kotlin3.bases.BaseNavFragment
import kg.geektech.kotlin3.bases.BaseViewModel
import kg.geektech.kotlin3.databinding.FragmentSelectBinding


class SelectFragment : BaseNavFragment<FragmentSelectBinding, BaseViewModel>() {
    private lateinit var args: SelectFragmentArgs
    private var list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = SelectFragmentArgs.fromBundle(requireArguments())
      /*  binding.btnBack.setOnClickListener {
            navigate(SelectFragmentDirections.actionSelectFragmentToGalleryFragment2())
        }*/
    }

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSelectBinding {
        return FragmentSelectBinding.inflate(inflater)
    }

    override fun initView() = with(binding) {
        super.initView()
        args.sheep?.toCollection(list)
        recyclerView.adapter = SelectedListAdapter(list)
    }

}