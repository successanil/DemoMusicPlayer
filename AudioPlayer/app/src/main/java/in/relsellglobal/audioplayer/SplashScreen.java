/*
 * Copyright (c) 2017. Relsell Global
 */

package in.relsellglobal.audioplayer;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new SplashEnd().execute();

    }

    public class SplashEnd extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            for(int i=0;i<300;i++) {
                // no task
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            intent = new Intent(SplashScreen.this, navigation_activity.class);
            startActivity(intent);
            finish();
        }
    }
}
