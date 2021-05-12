package com.nikasov.pagingexample.ui.activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.nikasov.pagingexample.databinding.ActivityMainBinding
import com.nikasov.pagingexample.ui.adapter.PassengerAdapter
import com.nikasov.pagingexample.ui.adapter.PassengerLoadStateAdapter
import com.nikasov.pagingexample.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var passengerAdapter: PassengerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setupList()
        setupViewModelCallbacks()
    }

    private fun setupViewModelCallbacks() {
        viewModel.apply {
            lifecycleScope.launchWhenCreated {
                passengerList.collectLatest { dataList ->
                    passengerAdapter.submitData(dataList)
                }
            }
        }
    }

    private fun setupList() {
        passengerAdapter.apply {
            withLoadStateHeaderAndFooter(
                header = PassengerLoadStateAdapter(),
                footer = PassengerLoadStateAdapter()
            )
            addLoadStateListener { state ->
                binding.postRecycler.isVisible = state.refresh != LoadState.Loading
                binding.loadingProgress.isVisible = state.refresh == LoadState.Loading
            }
        }

        binding.postRecycler.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = passengerAdapter
        }
    }
}