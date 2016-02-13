package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.h3u.myapplication.backend.jokeApi.JokeApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.h3u.gradle.androidjokelibrary.JokeActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String MAIN_FRAGMENT = "main_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityFragment fragment = new MainActivityFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment, fragment, MAIN_FRAGMENT)
                .commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentByTag(MAIN_FRAGMENT);
        fragment.enableProgressBar();

        new JokeApiEndpointAsyncTask().execute(this);
    }

    class JokeApiEndpointAsyncTask extends AsyncTask<Context, Void, String> {
        private JokeApi jokeApiService = null;
        private Context context;

        @Override
        protected String doInBackground(Context... params) {

            context = params[0];

            if (jokeApiService == null) {
                JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                        .setRootUrl(context.getString(R.string.joke_provider_root_url));
                jokeApiService = builder.build();
            }

            try {
                return jokeApiService.provideOne().execute().getData();
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Intent tellJoke = new Intent(getApplicationContext(), JokeActivity.class);
            tellJoke.putExtra(JokeActivity.INTENT_EXTRA_JOKE, result);
            startActivity(tellJoke);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentByTag(MAIN_FRAGMENT);
        fragment.disableProgressBar();
    }
}
