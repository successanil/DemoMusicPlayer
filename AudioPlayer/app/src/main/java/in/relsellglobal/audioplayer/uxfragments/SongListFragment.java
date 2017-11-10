/*
 * Copyright (c) 2017. Relsell Global
 */

/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.uxfragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import in.relsellglobal.audioplayer.ActivityListener;
import in.relsellglobal.audioplayer.R;
import in.relsellglobal.audioplayer.database.DBAlbumHandler;
import in.relsellglobal.audioplayer.database.DBHandler;
import in.relsellglobal.audioplayer.pojo.Song;

import java.util.ArrayList;


public class SongListFragment extends Fragment {

    RecyclerView recyclerView;

    public static ArrayList<Song> songsFromDatabase;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private ActivityListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SongListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            new FetchValues().execute();
        }

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);




    }


    public class FetchValues extends AsyncTask<Void, Void, ArrayList<Song>> {
        @Override
        protected void onPostExecute(ArrayList<Song> songsInList) {
            super.onPostExecute(songsInList);
            if(recyclerView!=null){
                recyclerView.setAdapter(new SongRecyclerViewAdapter(getActivity(),songsInList, mListener));

            }


        }

        @Override
        protected ArrayList<Song> doInBackground(Void... voids) {
            DBAlbumHandler dbAlbumHandler = new DBAlbumHandler(getActivity());
            DBHandler dbHandler = new DBHandler(getActivity());
            songsFromDatabase = dbHandler.fetchSongData();
            return songsFromDatabase;
        }
    }
}
