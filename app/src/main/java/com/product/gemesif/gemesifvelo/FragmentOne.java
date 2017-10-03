package com.product.gemesif.gemesifvelo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import junit.framework.Test;

import static com.product.gemesif.gemesifvelo.R.id.Button_v2h1_1;

public class FragmentOne extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    String DEBUG_TAG = "gemesifLog";

    GestureDetectorCompat mDetector;
    MyGestures mMyGestures;

    private String title;
    private int page;

    Button TestButton;

    // StringBuilder dest = new StringBuilder(4);

    // newInstance constructor for creating fragment with arguments
    public static FragmentOne newInstance(int page, String title) {

        // Log.d("DEBUG_TAG", "FragmentOne newInstance " + page);

        FragmentOne fragmentOne = new FragmentOne();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentOne.setArguments(args);
        return fragmentOne;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

        // mMyGestures = new MyGestures();
        // mDetector = new GestureDetectorCompat(getActivity(), mMyGestures);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        rootView.setOnTouchListener(new MyOnTouchListener());

        TextView tvLabel = (TextView) rootView.findViewById(R.id.text);
        tvLabel.setText((page + " -- " + title) + " " + tvLabel.getText());

        TestButton = (Button) rootView.findViewById(R.id.TesButton);
        // TestButton.setOnTouchListener(new MyOnTouchListener());

        TestButton.setOnClickListener(this);
        // TestButton.setOnLongClickListener(this);

        return rootView;
    }

    @Override
    public void onDestroy() {
        // Log.d(DEBUG_TAG , "FragmentOne onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.TesButton:
                // Log.d(DEBUG_TAG , "TestButton  onClick");
                break;

            default:
                break;
        }

    }

    @Override
    public boolean onLongClick(View v) {

        switch (v.getId()) {
            case R.id.TesButton:
                // Log.d(DEBUG_TAG , "TesButton  onLongClick");
                break;

            default:
                break;
        }

        return true;
    }

    /*
    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.mDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return true;
    }
    */
    /*
    @Override
    public boolean onDown(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDown: " + event.toString());
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
        return true;
    }
    */

    public class MyOnTouchListener implements View.OnTouchListener {

        String DEBUG_TAG = "gemesifLogA";

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            int action = MotionEventCompat.getActionMasked(motionEvent);

            // mDetector.onTouchEvent(motionEvent);
            // Log.d(DEBUG_TAG, "mDetector.onTouchEvent");

            switch (action) {
                case (MotionEvent.ACTION_DOWN):
                    // Log.d(DEBUG_TAG, "Action was DOWN");
                    return true;
                case (MotionEvent.ACTION_MOVE):
                    //Log.d(DEBUG_TAG, "Action was MOVE......");
                     return true;
                case (MotionEvent.ACTION_UP):
                    // Log.d(DEBUG_TAG, "Action was UP");
                    return true;
                case (MotionEvent.ACTION_CANCEL):
                    // Log.d(DEBUG_TAG, "Action was CANCEL");
                    return true;
                case (MotionEvent.ACTION_OUTSIDE):
                    // Log.d(DEBUG_TAG, "Movement occurred outside bounds " +  "of current screen element");
                    return true;
                default:
                    // Log.d(DEBUG_TAG, "Action was default");
                    return true;
            }
        }
    }

    public class MyGestures implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

        String DEBUG_TAG = "gemesifLogB";

        @Override
        public boolean onDown(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onDown: " + event.toString());
            return true;
        }

        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            // Log.d(DEBUG_TAG, "onFling: " + event1.toString() + event2.toString());
            return true;
        }

        @Override
        public void onLongPress(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onLongPress: " + event.toString());
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                                float distanceY) {
            // Log.d(DEBUG_TAG, "onScroll: " + e1.toString() + e2.toString());
            return true;
        }

        @Override
        public void onShowPress(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onShowPress: " + event.toString());
        }

        @Override
        public boolean onSingleTapUp(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onSingleTapUp: " + event.toString());
            return true;
        }
        @Override
        public boolean onDoubleTap(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onDoubleTap: " + event.toString());
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onDoubleTapEvent: " + event.toString());
            return true;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent event) {
            // Log.d(DEBUG_TAG, "onSingleTapConfirmed: " + event.toString());
            return true;
        }

    }
}
