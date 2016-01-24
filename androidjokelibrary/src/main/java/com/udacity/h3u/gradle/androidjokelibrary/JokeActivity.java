package com.udacity.h3u.gradle.androidjokelibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class JokeActivity extends AppCompatActivity {

    private static final String FRAGMENT = "JokeActivityFragment";

    public static final String INTENT_EXTRA_JOKE =
            JokeActivity.class.getCanonicalName() + ".INTENT_EXTRA_JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent jokeIntent = getIntent();
        if (null != jokeIntent) {
            String jokeText = jokeIntent.getStringExtra(JokeActivity.INTENT_EXTRA_JOKE);
            getSupportFragmentManager().beginTransaction().add(
                    R.id.fragment,
                    JokeActivityFragment.newInstance(jokeText), FRAGMENT
            ).commit();
        }
    }
}
