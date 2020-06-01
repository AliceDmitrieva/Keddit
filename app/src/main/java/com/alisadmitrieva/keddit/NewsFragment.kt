package com.alisadmitrieva.keddit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alisadmitrieva.keddit.adapter.NewsAdapter
import com.alisadmitrieva.keddit.commons.RedditNewsItem
import com.alisadmitrieva.keddit.commons.inflate
import kotlinx.android.synthetic.main.news_fragment.*

class NewsFragment : Fragment() {

    private val newsList by lazy {
        news_list
    }

    private val newsManager by lazy { NewsManager() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return container?.inflate(R.layout.news_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        news_list.setHasFixedSize(true)
        news_list.layoutManager = LinearLayoutManager(context)
        initAdapter()

        if (savedInstanceState == null) {
            val news = mutableListOf<RedditNewsItem>()
            for (i in 1..10) {
                news.add(
                    RedditNewsItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        "https://picsum.photos/200/200?image=$i",
                        "url"
                    )
                )
            }
        }
    }

    fun requestNews() {
        //   (news_list.adapter as NewsAdapter).addNews(news)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}
