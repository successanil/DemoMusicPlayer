/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.Songtable;

/**
 * Created by rahul on 1/11/17.
 */

public class Song {
    private int SongId;
    private String SongName;
    private String SongDescription;
    private String Category;


    public int getSongId() {
        return SongId;
    }

    public void setSongId(int SongId) {
        this.SongId = SongId;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String SongName) {
        this.SongName = SongName;
    }

    public String getSongDescription() {
        return SongDescription;
    }

    public void setSongDescription(String SongDescription) {
        this.SongDescription = SongDescription;
    }

    public String getCategory() {
        return Category;
    }

    public void  setCategory(String Category) {
        this.Category = Category;
    }
}
