/*
 * Copyright (c) 2017. Relsell Global
 */

/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.uxfragments;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import in.relsellglobal.audioplayer.ActivityListener;
import in.relsellglobal.audioplayer.R;
import in.relsellglobal.audioplayer.pojo.PojoInterface;
import in.relsellglobal.audioplayer.pojo.Song;

import java.util.ArrayList;


public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Song> mValues;
    private final ActivityListener mListener;
    private Context context;

    public SongRecyclerViewAdapter(Context context, ArrayList<Song> items, ActivityListener listener) {
        mValues = items;
        mListener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mSongName.setText(holder.mItem.getSongName());
//        holder.mSongImage.setImageDrawable(context.getResources().getDrawable(R.mipmap.navigationicon));


        /*holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MediaPlayer mp = MediaPlayer.create(context, R.raw.song);
                mp.start();
            }
        });*/

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(null != mListener){
                    PojoInterface pojoInterface = (PojoInterface)holder.mItem;
                    mListener.onListFragmentInteration(pojoInterface);
                    MediaPlayer mp = MediaPlayer.create(context, R.raw.song);
                    mp.start();
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mSongAnchor;
        public final ImageView mSongImage;
        public final TextView mSongName;

        public Song mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSongAnchor = (ImageView) view.findViewById(R.id.songAnchor);
            mSongImage = (ImageView) view.findViewById(R.id.songImage);
            mSongName = (TextView) view.findViewById(R.id.songName);

        }

    }
}
