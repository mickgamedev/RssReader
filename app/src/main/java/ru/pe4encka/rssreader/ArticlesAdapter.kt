package ru.pe4encka.rssreader

import com.prof.rssparser.Article
import ru.pe4encka.rssreader.databinding.CardArticleBinding

class ArticlesListAdapter : CategoryAdapter<Article, CardArticleBinding>(
    R.layout.card_article
) {
    override fun onBindViewHolder(holder: CategoryHolder<CardArticleBinding>, position: Int) =
        with(holder.binding) {
            //holder.itemView.setOnClickListener { onItemClick(position) }
            article = getItem(position)
            executePendingBindings()
        }
}