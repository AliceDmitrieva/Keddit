package com.alisadmitrieva.keddit.commons

import com.alisadmitrieva.keddit.adapter.AdapterConstants
import com.alisadmitrieva.keddit.adapter.ViewType

data class RedditNewsItem(
    val author: String,
    val title: String,
    val numComments: Int,
    val created: Long,
    val thumbnail: String,
    val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.NEWS
}