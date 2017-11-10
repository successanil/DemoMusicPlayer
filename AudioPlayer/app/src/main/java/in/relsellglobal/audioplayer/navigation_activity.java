/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer;

import android.support.v4.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import in.relsellglobal.audioplayer.pojo.Album;
import in.relsellglobal.audioplayer.pojo.PojoInterface;
import in.relsellglobal.audioplayer.pojo.Song;
import in.relsellglobal.audioplayer.uxfragments.AlbumDetailFragment;
import in.relsellglobal.audioplayer.uxfragments.MusicPlayerFragment;
//changed by ashish

public class navigation_activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ActivityListener {

        Intent serviceIntent;
        public Button play;
        public Button pause;
        ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_navigation_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);*/

        FragmentManager fm1 = getSupportFragmentManager();
        FragmentTransaction ft1 = fm1.beginTransaction();
        ft1.replace(R.id.contentLayout, new AlbumDetailFragment());
        ft1.commit();


        /* serviceIntent = new Intent(this, SongService.class);
        startService(serviceIntent);
        final SongService songService = new SongService();

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songService.playSong();
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songService.pauseSong();
            }
        });*/


        /*List<String> myList = new ArrayList<String>();
        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        myList.add("Fourth");
        myList.add("Fifth");
        myList.add("Sixth");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,myList);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);*/







    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




    @Override
    public void onListFragmentInteration(PojoInterface pojoInterface) {

        if(pojoInterface instanceof Album) {



        } else if(pojoInterface instanceof Song) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.album_detail_root,new MusicPlayerFragment());
            ft.commit();
        }

    }
}
