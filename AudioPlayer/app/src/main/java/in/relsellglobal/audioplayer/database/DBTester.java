/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.database;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import in.relsellglobal.audioplayer.pojo.Album;
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

            Album album1 = new Album();
            album1.setAlbumName("Michel Buble");
            db.addAlbumData(album1);

            Album album2 = new Album();
            album2.setAlbumName("Western Life");
            db.addAlbumData(album2);

            Album album3 = new Album();
            album3.setAlbumName("KSHMR");
            db.addAlbumData(album3);




            Song song1 = new Song();
            song1.setSongName("Feeling Good");
            song1.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song1.setAlbum("1");
            db.addSongData(song1);

            Song song2 = new Song();
            song2.setSongName("Sorry");
            song2.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song2.setAlbum("1");
            db.addSongData(song2);


            Song song3 = new Song();
            song3.setSongName("Feeling Good");
            song3.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song3.setAlbum("2");
            db.addSongData(song1);


            Song song4 = new Song();
            song4.setSongName("Sorry");
            song4.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song4.setAlbum("2");
            db.addSongData(song2);

            Song song5 = new Song();
            song5.setSongName("Sorry");
            song5.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song5.setAlbum("3");
            db.addSongData(song2);

            Song song6 = new Song();
            song6.setSongName("Feeling Good");
            song6.setSongDescription("/storage/emulated/0/Download/feeling_good.mp3");
            song6.setAlbum("3");
            db.addSongData(song1);





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


