package com.example.gronk.tribalgronk555;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    public static final String TWITTER_KEY = "HSKXh145J43FLRe65Npxfa2eN";
    public static final String TWITTER_SECRET = "uwxfuN6dIPRBQXPIoJ4KGFHX67OupY40QG87doDr3BdNOvpIoM";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);
    }

    public void gotoTwitter(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
