/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumImage extends Fragment {



    public AlbumImage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_album_image, container, false);


        /*TextView textView = (TextView) v.findViewById(R.id.SlideShow);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setText("Feeling Good...");
        textView.setSelected(true);
        textView.setSingleLine(true);*/

        WebView webView = (WebView) v.findViewById(R.id.web);
        String summary = "<html><FONT color='#F3383F' FACE='courier'>"+
                "<marquee behavior='scroll' direction='left' scrollamount=5>"+
                "Feeling Good...</marquee></FONT></html>";
        webView.loadData(summary, "text/html", "utf-8");


        return  v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }
}
