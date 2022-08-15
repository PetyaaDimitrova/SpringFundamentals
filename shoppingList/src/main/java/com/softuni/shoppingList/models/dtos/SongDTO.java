package com.softuni.shoppingList.models.dtos;

import com.softuni.shoppingList.models.Song;
import com.softuni.shoppingList.models.Style;

public class SongDTO {

    private String performer;
    private String title;
    private int duration;
    private Style style;

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public SongDTO() {
    }

    public SongDTO(Song song) {
        this.duration = song.getDuration();
        this.performer = song.getPerformer();
        this.title = song.getTitle();
    }

    public SongDTO(SongDTO songDTO) {
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
