package com.nikasov.pagingexample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikasov.pagingexample.databinding.ActivityMainBinding
import com.nikasov.pagingexample.ui.adapter.PostAdapter
import com.nikasov.pagingexample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupList()
        setupViewModelCallbacks()
    }

    private fun setupViewModelCallbacks() {
        viewModel.apply {
            postList.observe(this@MainActivity, { list ->
                postAdapter.items = list
            })
        }
    }

    private fun setupList() {
        binding.postRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }
    }
}