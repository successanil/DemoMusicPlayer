/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.database;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.relsellglobal.audioplayer.pojo.Song;

/**
 * Created by rahul on 2/11/17.
 */

public class DBTester extends AppCompatActivity {
    DBHandler db;



    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
       //setContentView(R.layout.activity_main);
        db = new DBHandler(DBTester.this);

        new DBWriter().execute();

      //  new DBReader().execute();
    }
    public class DBWriter extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... params) {
            Song song1 = new Song();
            song1.setSongName("Feeling Good");
            song1.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song1.setAlbum("1");
            db.addSongData(song1);

            Song song2 = new Song();
            song2.setSongName("Sorry");
            song2.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song2.setAlbum("2");
            db.addSongData(song2);

            return null;
        }
    }


    public class DBReader extends AsyncTask<Void,Void,Song> {

        @Override
        protected Song doInBackground(Void... params) {
           // Song song = db.fetchSongData();
            return null;
             }

        @Override
        protected void onPostExecute(Song song) {
            super.onPostExecute(song);
            Toast.makeText(DBTester.this,"Song for song No 1 is = "+song.getSongName(),Toast.LENGTH_LONG).show();

        }
    }


}


