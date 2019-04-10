package ru.pe4encka.rssreader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import ru.pe4encka.rssreader.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        model = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.apply {
            viewModel = model
            recycler.adapter = model.articleAdapter
            recycler.layoutManager = LinearLayoutManager(this@MainActivity)
        }

    }
}
