package kg.geektech.kotlin3

import android.view.LayoutInflater
import kg.geektech.kotlin3.bases.BaseActivity
import kg.geektech.kotlin3.bases.BaseViewModel
import kg.geektech.kotlin3.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, BaseViewModel>() {
    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }
}