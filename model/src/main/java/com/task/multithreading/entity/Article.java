package com.task.multithreading.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.ZonedDateTime;


@Entity
@Table(name = "articles")
public class Article extends AbstractEntity {

    @Column(name = "title")
    private String title;

    @Column(name = "news_site")
    private String newsSite;

    @Column(name = "published_date")
    private ZonedDateTime publishedDate;

    @Column(columnDefinition = "TEXT")
    private String article;

    public Article() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsSite() {
        return newsSite;
    }

    public void setNewsSite(String newsSite) {
        this.newsSite = newsSite;
    }

    public ZonedDateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(ZonedDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article1 = (Article) o;

        if (title != null ? !title.equals(article1.title) : article1.title != null) return false;
        if (newsSite != null ? !newsSite.equals(article1.newsSite) : article1.newsSite != null) return false;
        if (publishedDate != null ? !publishedDate.equals(article1.publishedDate) : article1.publishedDate != null)
            return false;
        return article != null ? article.equals(article1.article) : article1.article == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (newsSite != null ? newsSite.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (article != null ? article.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", newsSite='" + newsSite + '\'' +
                ", publishedDate=" + publishedDate +
                ", article='" + article + '\'' +
                '}';
    }
}
