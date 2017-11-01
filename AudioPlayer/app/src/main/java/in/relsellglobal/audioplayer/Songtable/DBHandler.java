/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.Songtable;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rahul on 1/11/17.
 */

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Song.db";
    public static final int DATABASE_VERSION = 1;
    public static final String Song_TABLE = "Song";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "SongName";
    private static final String KEY_SongDescription = "SongDescription";
    private static final String KEY_Category="Category";



    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CUSTOMER_TABLE = "CREATE TABLE " + Song_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_SongDescription + " STRING, " + KEY_Category+" TEXT)";
        db.execSQL(CREATE_CUSTOMER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Song_TABLE);
        // Create tables again
        onCreate(db);
    }

    public void addSongData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME,obj.getSongName());
        values.put(KEY_SongDescription,obj.getSongDescription());
        values.put(KEY_Category,obj.getCategory());

        // Inserting Row
        db.insert(Song_TABLE, null, values);
        db.close(); // Closing database connection

    }

    public void removeSongData(Song obj) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Song_TABLE, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getSongId()) });
        db.close();

    }

    public int updateSongData(Song obj) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, obj.getSongName());
        values.put(KEY_SongDescription, obj.getSongDescription());

        // updating row
        return db.update(Song_TABLE, values, KEY_ID + " = ?",
                new String[] { String.valueOf(obj.getSongId()) });

    }

    public Song fetchSongData(String SongDescription) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Song_TABLE, new String[] { KEY_ID,
                        KEY_NAME, KEY_SongDescription,KEY_Category }, KEY_SongDescription + "=?",
                new String[] { String.valueOf(SongDescription) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Song song = new Song();
        song.setSongId(cursor.getInt(cursor.getColumnIndexOrThrow(KEY_ID)));
        song.setSongName(cursor.getString(cursor.getColumnIndexOrThrow(KEY_NAME)));
        song.setSongDescription(cursor.getString(cursor.getColumnIndexOrThrow(KEY_SongDescription)));
        song.setCategory(cursor.getString(cursor.getColumnIndexOrThrow(KEY_Category)));

        return song;
    }


}
