package kg.geektech.kotlin3.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding, VM : BaseViewModel> : Fragment() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateViewBinding(layoutInflater)
        return binding.root
    }

    open fun initView() {} // Инициализации вьюшек
    open fun initListener() {} // Прописываем все логику кликов
    open fun initViewModel() {}// Обрабатываем все обзерверы
    open fun checkInternet() {}
}