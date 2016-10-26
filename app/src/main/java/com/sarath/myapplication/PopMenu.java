package com.sarath.myapplication;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;


/**
 * Created by sarath on 10/26/2016.
 */

public class PopMenu extends AppCompatActivity {

    Button button;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.changeBakground);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void popup(View view) {
        PopupMenu pm = new PopupMenu(getBaseContext(), view);
        MenuInflater inflater = pm.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, pm.getMenu());
        pm.show();

        switch (view.getId()) {
            case R.id.pBlue:
                button.setBackgroundColor(Color.BLUE);
                break;
            case R.id.pGreen:
                button.setBackgroundColor(Color.GREEN);
                break;
            case R.id.pred:
                button.setBackgroundColor(Color.RED);
                break;
            case R.id.pCyan:
                button.setBackgroundColor(Color.CYAN);
                break;
            case R.id.pYellow:
                button.setBackgroundColor(Color.YELLOW);
                break;
        }
    }


}
