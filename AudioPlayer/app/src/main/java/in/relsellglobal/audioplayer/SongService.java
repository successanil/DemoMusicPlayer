/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Button;

/**
 * Created by jack-sparrow on 26/10/17.
 */

public class SongService extends Service {

    public MediaPlayer mediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mediaPlayer = MediaPlayer.create(SongService.this, R.raw.song);

        mediaPlayer.start();

        return super.onStartCommand(intent, flags, startId);
    }



}
