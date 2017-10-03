package com.product.gemesif.gemesifvelo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentTwo extends Fragment {

    String DEBUG_TAG = "gemesifLog";

    // Store instance variables
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FragmentTwo newInstance(int page, String title) {

        FragmentTwo fragmentTwo = new FragmentTwo();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentTwo.setArguments(args);
        return fragmentTwo;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.text);
        tvLabel.setText((page + " -- " + title) + " " + tvLabel.getText());
        return view;
    }

    @Override
    public void onPause(){
        Log.d(DEBUG_TAG, "FragmentTwo onPause");
        super.onPause();
    }

    public void onStop() {
        Log.d(DEBUG_TAG, "FragmentTwo onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.d(DEBUG_TAG, "FragmentTwo onDestroy");
        super.onDestroy();
    }
}
