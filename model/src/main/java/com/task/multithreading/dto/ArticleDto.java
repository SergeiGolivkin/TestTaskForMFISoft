package com.task.multithreading.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.time.ZonedDateTime;
import java.util.Arrays;

@Data
public class ArticleDto {

    private String id;

    private String title;

    private String newsSite;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private ZonedDateTime publishedAt;

    private String summary;

    private String url;

    private String imageUrl;

    public String updatedAt;

    public boolean featured;

    public Object[] launches;

    public Object[] events;

//    public ArticleDto() {
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getNewsSite() {
//        return newsSite;
//    }
//
//    public void setNewsSite(String newsSite) {
//        this.newsSite = newsSite;
//    }
//
//    public ZonedDateTime getPublishedAt() {
//        return publishedAt;
//    }
//
//    public void setPublishedAt(String publishedAt) {
//        this.publishedAt = ZonedDateTime.parse(publishedAt);
//    }
//
//    public String getSummary() {
//        return summary;
//    }

//    public void setSummary(String summary) {
//        this.summary = summary;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getImageUrl() {
//        return imageUrl;
//    }
//
//    public void setImageUrl(String imageUrl) {
//        this.imageUrl = imageUrl;
//    }
//
//    public String getUpdatedAt() {
//        return updatedAt;
//    }
//
//    public void setUpdatedAt(String updatedAt) {
//        this.updatedAt = updatedAt;
//    }

//    public boolean isFeatured() {
//        return featured;
//    }
//
//    public void setFeatured(boolean featured) {
//        this.featured = featured;
//    }
//
//    public Object[] getLaunches() {
//        return launches;
//    }
//
//    public void setLaunches(Object[] launches) {
//        this.launches = launches;
//    }
//
//    public Object[] getEvents() {
//        return events;
//    }
//
//    public void setEvents(Object[] events) {
//        this.events = events;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleDto that = (ArticleDto) o;

        if (featured != that.featured) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (newsSite != null ? !newsSite.equals(that.newsSite) : that.newsSite != null) return false;
        if (publishedAt != null ? !publishedAt.equals(that.publishedAt) : that.publishedAt != null) return false;
        if (summary != null ? !summary.equals(that.summary) : that.summary != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (imageUrl != null ? !imageUrl.equals(that.imageUrl) : that.imageUrl != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(launches, that.launches)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(events, that.events);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (newsSite != null ? newsSite.hashCode() : 0);
        result = 31 * result + (publishedAt != null ? publishedAt.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (featured ? 1 : 0);
        result = 31 * result + Arrays.hashCode(launches);
        result = 31 * result + Arrays.hashCode(events);
        return result;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", newsSite='" + newsSite + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", summary='" + summary + '\'' +
                ", url='" + url + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", featured=" + featured +
                ", launches=" + Arrays.toString(launches) +
                ", events=" + Arrays.toString(events) +
                '}';
    }


}
