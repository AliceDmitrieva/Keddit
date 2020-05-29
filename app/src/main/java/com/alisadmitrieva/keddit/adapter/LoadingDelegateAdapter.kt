package com.alisadmitrieva.keddit.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alisadmitrieva.keddit.R
import com.alisadmitrieva.keddit.commons.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        parent.inflate(R.layout.news_item_loading)) {
    }
}
