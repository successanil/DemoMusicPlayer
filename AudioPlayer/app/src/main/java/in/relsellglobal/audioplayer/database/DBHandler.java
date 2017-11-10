/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import in.relsellglobal.audioplayer.pojo.Album;
import in.relsellglobal.audioplayer.pojo.Song;

import static in.relsellglobal.audioplayer.database.DBHandler.SongTable.KEY_Album;
import static in.relsellglobal.audioplayer.database.DBHandler.SongTable.KEY_ID;
import static in.relsellglobal.audioplayer.database.DBHandler.SongTable.KEY_NAME;
import static in.relsellglobal.audioplayer.database.DBHandler.SongTable.KEY_SongDescription;
import static in.relsellglobal.audioplayer.database.DBHandler.SongTable.TABLE;

/**
 * Created by rahul on 1/11/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Song.db";
    public static final int DATABASE_VERSION = 1;




    public class SongTable {

        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "SongName";
        public static final String KEY_SongDescription = "SongDescription";
        public static final String KEY_Album="Album";
        public static final String TABLE = "Song";


    }

    public class AlbumTable{
        public static final String KEY_ID = "id";
        public static final String KEY_NAME = "AlbumName";
        public static final String TABLE = "Album";



    }





    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + SongTable.TABLE + "("
                + SongTable.KEY_ID + " INTEGER PRIMARY KEY," + SongTable.KEY_NAME + " TEXT,"
                + SongTable.KEY_SongDescription + " STRING, " + SongTable.KEY_Album+" TEXT)";
        db.execSQL(CREATE_CUSTOMER_TABLE);

        String CREATE_Album_TABLE = "CREATE TABLE " + AlbumTable.TABLE + "("
                + AlbumTable.KEY_ID + " INTEGER PRIMARY KEY," + AlbumTable.KEY_NAME + " TEXT,"
                + " )";
        db.execSQL(CREATE_Album_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SongTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + AlbumTable.TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addAlbumData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(AlbumTable.KEY_NAME, obj.getSongName());

        // Inserting Row
        db.insert(AlbumTable.TABLE, null, values);
        db.close(); // Closing database connection

    }


    public ArrayList<Album> fetchAlbumData() {


        ArrayList<Album> AlbumArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(AlbumTable.TABLE, new String[] { AlbumTable.KEY_ID,
                AlbumTable.KEY_NAME }, null , null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            do{
                Album album = new Album();
                album.setAlbumId(cursor.getInt(cursor.getColumnIndexOrThrow(AlbumTable.KEY_ID)));
                album.setAlbumName(cursor.getString(cursor.getColumnIndexOrThrow(AlbumTable.KEY_NAME)));


                AlbumArrayList.add(album);

            }while(cursor.moveToNext());

        }


        return AlbumArrayList;
    }



    public void addSongData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,obj.getSongName());
        values.put(KEY_SongDescription,obj.getSongDescription());
        values.put(KEY_Album,obj.getAlbum());

        // Inserting Row
        db.insert(SongTable.TABLE, null, values);
        db.close(); // Closing database connection

    }

    public void removeSongData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SongTable.TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getSongId()) });
        db.close();

    }

    public int updateSongData(Song obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, obj.getSongName());
        values.put(KEY_SongDescription, obj.getSongDescription());

        // updating row
        return db.update(SongTable.TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getSongId()) });

    }

    public ArrayList<Song> fetchSongData() {


        ArrayList<Song> songArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(SongTable.TABLE, new String[] { KEY_ID,
                        KEY_NAME, KEY_SongDescription,KEY_Album }, null , null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            do{
                Song song = new Song();
                song.setSongId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
                song.setSongName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
                song.setSongDescription(cursor.getString(cursor.getColumnIndexOrThrow(KEY_SongDescription)));
                song.setAlbum(cursor.getString(cursor.getColumnIndexOrThrow(KEY_Album)));

                songArrayList.add(song);

            }while(cursor.moveToNext());

        }


        return songArrayList;
    }


}
