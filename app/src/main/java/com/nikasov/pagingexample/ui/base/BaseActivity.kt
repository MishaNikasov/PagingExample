package com.nikasov.pagingexample.ui.base

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

open class BaseActivity<ActivityBinding: ViewDataBinding>: AppCompatActivity() {
    lateinit var binding: ActivityBinding
}