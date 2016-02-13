package com.udacity.h3u.gradle.androidjokelibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    private static final String ARG_JOKE = "arg_joke";
    private static final String KEY_JOKE = "key_joke";

    private String mParamJoke;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param joke JOke to display.
     * @return A new instance of fragment JokeFragment.
     */
    public static JokeActivityFragment newInstance(String joke) {
        JokeActivityFragment fragment = new JokeActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_JOKE, joke);
        fragment.setArguments(args);
        return fragment;
    }

    public JokeActivityFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamJoke = getArguments().getString(ARG_JOKE);
        } else if (savedInstanceState != null) {
            mParamJoke = savedInstanceState.getString(KEY_JOKE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        // set joke text
        TextView joke = (TextView) rootView.findViewById(R.id.text_view_joke);
        joke.setText(mParamJoke);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_JOKE, mParamJoke);
    }
}
