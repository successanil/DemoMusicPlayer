/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.Songtable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by rahul on 3/11/17.
 */

public class DBAlbumHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Album.db";
    public static final int DATABASE_VERSION = 1;
    public static final String ALBUM_TABLE = "Album";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "AlbumName";

    public DBAlbumHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Album_TABLE = "CREATE TABLE " + ALBUM_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + " )";
        db.execSQL(CREATE_Album_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ALBUM_TABLE);
        // Create tables again
        onCreate(db);

    }

    public void addAlbumData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, obj.getSongName());

        // Inserting Row
        db.insert(ALBUM_TABLE, null, values);
        db.close(); // Closing database connection

    }


    public ArrayList<Album> fetchAlbumData() {


        ArrayList<Album> AlbumArrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(ALBUM_TABLE, new String[] { KEY_ID,
                KEY_NAME }, null , null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            do{
                Album album = new Album();
                album.setAlbumId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
                album.setAlbumName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));


                AlbumArrayList.add(album);

            }while(cursor.moveToNext());

        }


        return AlbumArrayList;
    }



}




