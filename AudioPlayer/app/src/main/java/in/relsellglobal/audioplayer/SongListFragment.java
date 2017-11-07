/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Button;

import in.relsellglobal.audioplayer.Songtable.DBAlbumHandler;
import in.relsellglobal.audioplayer.Songtable.DBHandler;
import in.relsellglobal.audioplayer.Songtable.Song;
import in.relsellglobal.audioplayer.dummy.DummyContent;
import in.relsellglobal.audioplayer.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SongListFragment extends Fragment {

    RecyclerView recyclerView;

    public static ArrayList<Song> songsFromDatabase;

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private OnListFragmentInteractionListener mListener;

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
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

    public class FetchValues extends AsyncTask<Void, Void, ArrayList<Song>> {
        @Override
        protected void onPostExecute(ArrayList<Song> songsInList) {
            super.onPostExecute(songsInList);
            if(recyclerView!=null){
                recyclerView.setAdapter(new MyItemRecyclerViewAdapter(getActivity(),songsInList, mListener));

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
