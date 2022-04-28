package kg.geektech.kotlin3.bases

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var binding: VB
    protected lateinit var viewModel: VM

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding(layoutInflater)
        setContentView(binding.root)

        checkInternet()
        initViewModel()
        initView()
        initListener()
    }

    open fun initView() {} // Инициализации вьюшек
    open fun initListener() {} // Прописываем все логику кликов
    open fun initViewModel() {}// Обрабатываем все обзерверы
    open fun checkInternet() {}
}