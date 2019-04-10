package ru.pe4encka.rssreader

import android.util.Log
import androidx.lifecycle.ViewModel
import com.prof.rssparser.Parser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    private val url = "https://www.androidauthority.com/feed"
    private val viewModelJob = Job()
    private val mainScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    val articleAdapter = ArticlesListAdapter()

    init {
        mainScope.launch {
            val parser = Parser()
            val articleList = parser.getArticles(url)
            articleAdapter.setItems(articleList)
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}