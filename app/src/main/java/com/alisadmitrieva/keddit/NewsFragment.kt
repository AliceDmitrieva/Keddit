package com.alisadmitrieva.keddit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.alisadmitrieva.keddit.adapter.NewsAdapter
import com.alisadmitrieva.keddit.commons.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.news_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class NewsFragment : RxBaseFragment() {

    private var redditNews: RedditNews? = null
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
        val linearLayout = LinearLayoutManager(context)

        news_list.layoutManager = linearLayout
        news_list.clearOnScrollListeners()
        news_list.addOnScrollListener(InfiniteScrollListener({ requestNews() }, linearLayout))
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
        val subscription = newsManager.getNews(redditNews?.after ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { retrievedNews ->
                    (news_list.adapter as NewsAdapter).addNews(retrievedNews.news!!)
                },
                { e ->
                    Snackbar.make(news_list, e.message ?: "", Snackbar.LENGTH_LONG).show()
                }
            )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (news_list.adapter == null) {
            news_list.adapter = NewsAdapter()
        }
    }
}
