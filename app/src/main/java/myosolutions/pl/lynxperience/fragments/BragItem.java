package myosolutions.pl.lynxperience.fragments;

import android.graphics.drawable.Drawable;

/**
 * Created by Jacek on 2017-06-27.
 */

public class BragItem {

    private Drawable photo;
    private String description;
    private String title;
    private String url;

    public BragItem(Drawable photo, String description, String title, String url) {
        this.photo = photo;
        this.description = description;
        this.title = title;
        this.url = url;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "BragItem{" +
                "photo=" + photo +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
