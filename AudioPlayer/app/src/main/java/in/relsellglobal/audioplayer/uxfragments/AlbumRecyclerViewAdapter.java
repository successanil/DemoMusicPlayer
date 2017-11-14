/*
 * Copyright (c) 2017. Relsell Global
 */

/*
 * Copyright (c) 2017. Relsell Global
 */

/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer.uxfragments;

import in.relsellglobal.audioplayer.ActivityListener;
import in.relsellglobal.audioplayer.R;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import in.relsellglobal.audioplayer.pojo.Album;
import in.relsellglobal.audioplayer.pojo.PojoInterface;

import java.util.List;


public class AlbumRecyclerViewAdapter extends RecyclerView.Adapter<AlbumRecyclerViewAdapter.ViewHolder> {

    private final List<Album> mValues;
    private final ActivityListener mListener;

    public AlbumRecyclerViewAdapter(List<Album> items, ActivityListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_albumitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mAlbumName.setText(holder.mItem.getAlbumName());


        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    PojoInterface pojoInterface = (PojoInterface) holder.mItem;
                    mListener.onListFragmentInteration(pojoInterface);
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
        public final ImageView mImageView;
        public final TextView mAlbumName;
        public Album mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.albumImage);
            mAlbumName = (TextView) view.findViewById(R.id.albumName);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mAlbumName.getText() + "'";
        }
    }
}
