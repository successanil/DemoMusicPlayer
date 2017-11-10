/*
 * Copyright (c) 2017. Relsell Global
 */

/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.pojo;

/**
 * Created by rahul on 3/11/17.
 */
public class Album implements PojoInterface {
    private int AlbumId;
    private String AlbumName;
    private String Album;


    public int getAlbumId() {
        return AlbumId;
    }

    public void setAlbumId(int AlbumId) {
        this.AlbumId = AlbumId;
    }

    public String getAlbumName() {
        return AlbumName;
    }

    public void setAlbumName(String AlbumName) {
        this.AlbumName = AlbumName;
    }



    public String getAlbum() {
        return Album;
    }

    public void  setAlbum(String Album) {
        this.Album = Album;
    }
}