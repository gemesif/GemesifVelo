
package com.product.gemesif.gemesifvelo;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.product.gemesif.gemesifvelo.GemesifVeloGlobal.DayNightTheme;
import com.product.gemesif.gemesifvelo.GemesifVeloGlobal.AppearanceType;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.product.gemesif.gemesifvelo.GemesifVeloGlobal.AppearanceColorButton;
import static com.product.gemesif.gemesifvelo.GemesifVeloGlobal.colorDayNightInverse;

public class FragmentSpeed extends Fragment implements View.OnClickListener, View.OnLongClickListener {

    String DEBUG_TAG = "gemesifLogAB";

    View rootView;
    MyOnTouchListener myOnTouchListener;
    Button Button_v2h1_1;
    int cikl = 0;
    private String title;
    private int page;
    private Runnable mTicker;

    // newInstance constructor for creating fragment with arguments
    public static FragmentSpeed newInstance(int page, String title) {
        FragmentSpeed frSpeed = new FragmentSpeed();

        // Log.d("gemesifLog", "1. fragemt title: " + title);
        // Log.d("gemesifLog", "FragmentSpeed newInstance " + page);

        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        frSpeed.setArguments(args);
        return frSpeed;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

        // Log.d("gemesifLog", "FragmentSpeed  onCreate " + savedInstanceState);

        if (savedInstanceState == null) {
            // Log.d("gemesifLog", "FragmentSpeed  onCreate NULL savedInstanceState");
        } else {
            // Log.d("gemesifLog", "FragmentSpeed  onCreate Not NULL savedInstanceState");
        }

        // Log.d("gemesifLog", "FragmentSpeed  onCreate " + page);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Log.d(DEBUG_TAG, "FragmentSpeed  onCreateView " + page);

        rootView = inflater.inflate(R.layout.fragment_speed, container, false);

        initColorTable();
        // scanningViewGroup(DayNightTheme.NIGHT_THEME, (ViewGroup) rootView);
        // setViewGroup(GemesifVeloGlobal.currentDayNightTheme, (ViewGroup) rootView);
        scanningViewGroup(GemesifVeloGlobal.currentDayNightTheme, (ViewGroup) rootView); // AA
        // getColorbyName(GemesifVeloGlobal.themeColors);
        // list_colorDayNight();

        if (rootView != null) {
            // Log.d("gemesifLog", "fragemt is");
            // return view;
        } else {
            // Log.d("DEBUG_TAG", "fragemt is NOT");
        }

        rootView.setOnTouchListener(new MyOnTouchListener());

        TextView tvLabel = (TextView) rootView.findViewById(R.id.text);
        tvLabel.setText((page + " -- " + title) + " " + tvLabel.getText());

        mTicker = new Runnable() {
            @Override
            public void run() {
                Handler mHandler;
                mHandler = new Handler();
                long now = SystemClock.uptimeMillis();
                long next = now + (1000L - now % 1000L);
                TextView textTest = (TextView) rootView.findViewById(R.id.test);
                textTest.setText(Integer.toString(cikl++));
                mHandler.postAtTime(mTicker, next);
            }
        };
        mTicker.run();

        Button_v2h1_1 = (Button) rootView.findViewById(R.id.Button_v2h1_1);
        Button_v2h1_1.setOnClickListener(this);
        Button_v2h1_1.setOnLongClickListener(this);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Log.d(DEBUG_TAG, "onActivityCreated ");

    }

    @Override
    public void onResume() {
        super.onResume();
        // ((MainActivity)getActivity()).getSupportActionBar().hide();
        // Log.d("gemesifLog", "onResume hide Toolbar");

    }

    @Override
    public void onStop() {
        super.onStop();
        // ((MainActivity)getActivity()).getSupportActionBar().show();
        // Log.d("gemesifLog", "onStop show Toolbar");

    }

    @Override
    public void onDestroy() {
        // Log.d(DEBUG_TAG , "FragmentOne onDestroy");
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.Button_v2h1_1:
                // Log.d("gemesifLog", "Button_v2h1_1  onClick");
                break;

            default:
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {

        switch (v.getId()) {
            case R.id.Button_v2h1_1:
                // Log.d("gemesifLog", "Button_v2h1_1  onLongClick");
                break;

            default:
                break;
        }

        return true;
    }

    public void scanningViewGroup(DayNightTheme daynight, ViewGroup viewGroup) {

        View child;
        String IdAsString;
        int color;

        // Log.d(DEBUG_TAG, "scanningViewGroup ");
        IdAsString = viewGroup.getResources().getResourceName(viewGroup.getId());

        if (findCatching(GemesifVeloGlobal.patternNOTAG, IdAsString)) {

            adjustViewGroupBackground((ViewGroup) viewGroup, daynight, GemesifVeloGlobal.AppearanceColorBackground(AppearanceType.NORMAL));

            // Log.d(DEBUG_TAG, "NOTAG " + IdAsString);

        } else if (findCatching(GemesifVeloGlobal.patternSEP, IdAsString)) {

            adjustViewGroupBackground((ViewGroup) viewGroup, daynight, GemesifVeloGlobal.AppearanceColorBackground(AppearanceType.SEP));

            // Log.d(DEBUG_TAG, "SEP " + IdAsString);

        } else if (findCatching(GemesifVeloGlobal.patternBLACKBACKGROUNDSEP, IdAsString)) {

            adjustViewGroupBackground((ViewGroup) viewGroup, daynight, GemesifVeloGlobal.AppearanceColorBackground(AppearanceType.BLACKBACKGROUNDSEP));

            // Log.d(DEBUG_TAG, "BLACKBACKGROUNDSEP " + " " + IdAsString);

        } else {

            // Log.d(DEBUG_TAG, "No Catch " + IdAsString);

        }

        for (int i = 0; i < viewGroup.getChildCount(); i++) {

            // Log.d(DEBUG_TAG, "scanningViewGroup i: " + i);

            child = viewGroup.getChildAt(i);

            IdAsString = child.getResources().getResourceName(child.getId());

            // Log.d(DEBUG_TAG, "ID as String : " + IdAsString);

            if (child instanceof ViewGroup) {

                // Log.d(DEBUG_TAG, "Pattern for search: " + pattern + " " + IdAsString);

                Drawable background = child.getBackground();
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                    // Log.d(DEBUG_TAG, "Color background: " + String.format("#%06X", (0xFFFFFF & color)));
                }

                // Log.d(DEBUG_TAG, "New scanningViewGroup i:" + i);
                scanningViewGroup(daynight, (ViewGroup) child);

            } else {

                if (child instanceof Button) {
                    Log.d(DEBUG_TAG, "Button");

                    /*

                    Button button = (Button) child;
                    StateListDrawable states = new StateListDrawable();
                    states.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.RED)));
                    states.addState(new int[]{}, new ColorDrawable(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.YELLOW1)));
                    button.setBackground(states);

                    ColorStateList colorStates = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{}}, new int[]{
                            getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.BLUE2), getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.RED)});
                    button.setTextColor(colorStates);

                    */

                    adjustButton((Button) child, daynight, AppearanceColorButton());

                } else if (child instanceof TextView) {


                    if (findCatching(GemesifVeloGlobal.patternNOTAG, IdAsString)) {


                        // Log.d(DEBUG_TAG, "TextView");
                        // Log.d(DEBUG_TAG, "ID as String : " + IdAsString);

                        adjustTextView((TextView) child, daynight, GemesifVeloGlobal.AppearanceColorTextView(AppearanceType.NORMAL));

                    } else if (findCatching(GemesifVeloGlobal.patternSEP, IdAsString)) {

                        // Log.d(DEBUG_TAG, "TextView Sep");
                        // Log.d(DEBUG_TAG, "ID as String : " + IdAsString);

                        adjustTextView((TextView) child, daynight, GemesifVeloGlobal.AppearanceColorTextView(AppearanceType.SEP));

                    } else {

                    }

                    // ((TextView) child).setBackgroundColor(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.YELLOW1));
                    // ((TextView) child).setTextColor(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.RED));

                } else {

                    // Log.d(DEBUG_TAG, "Unknown type");

                }
            }

        }
    }

    public boolean findCatching(Pattern pattern, String string) {

        // Log.d(DEBUG_TAG, "findPattern");

        // Log.d(DEBUG_TAG, "Pattern: " + GemesifVeloGlobal.appearanceTypeStrinRegexp.get(AppearanceType.SEP));

        // Pattern pattern = Pattern.compile(GemesifVeloGlobal.appearanceTypeStrinRegexp.get(AppearanceType.BLACKBACKGROUNDSEP));
        // Pattern pattern = Pattern.compile("_TAG_BlackBgSep");
        // Matcher matcher = pattern.matcher("com.product.gemesif.gemesifvelo:id/linearLayout_Sep_v2_h3_v2_TAG_BlackBgSep");
        // boolean booleanMatch = matcher.matches();

        // Log.d(DEBUG_TAG, "booleanMatch: " + booleanMatch + " pattern: " + "TAG_BlackBgSep" + " " + "com.product.gemesif.gemesifvelo:id/linearLayout_Sep_v2_h3_v2_TAG_BlackBgSep");
        // Log.d(DEBUG_TAG, "booleanMatch: " + booleanMatch + " " + matcher.group(1) + " " + matcher.group(2));

        Matcher matcher = pattern.matcher(string);
        boolean booleanMatch = matcher.matches();

        // Log.d(DEBUG_TAG, "findCatching booleanMatch: " + booleanMatch + " pattern: " + pattern + " " + "string: " + string);

        return booleanMatch;

    }

    public void initColorTable() {

        int colorResId;
        int color;

        for (Map.Entry<GemesifVeloGlobal.ThemeColors, GemesifVeloGlobal.ColorTable> entry : GemesifVeloGlobal.colorDayNight_Data.entrySet()) {

            // Log.d(DEBUG_TAG, "iteration " + entry.getKey() + " " +  entry.getValue().getColorString());

            colorResId = getActivity().getResources().getIdentifier(entry.getValue().getColorString(), "color", getActivity().getPackageName());
            color = ContextCompat.getColor(getContext(), colorResId);

            entry.getValue().setColorValue(color);
        }

        for (Map.Entry<GemesifVeloGlobal.ThemeColors, GemesifVeloGlobal.ColorTable> entry : GemesifVeloGlobal.colorDayNight_Data.entrySet()) {

            // Log.d(DEBUG_TAG, "iteration " + entry.getKey() + " " +  entry.getValue().getColorString() + " " + String.format("#%06X", (0xFFFFFF & entry.getValue().getColorValue())));

        }

        String s = GemesifVeloGlobal.colorDayNight_Data.get(GemesifVeloGlobal.ThemeColors.GREY05).getColorString();

        // Log.d(DEBUG_TAG, "color string " + s);

    }

    public int getColorDayNight_Data(GemesifVeloGlobal.ThemeColors key) {

        // String s = GemesifVeloGlobal.colorDayNight_Data.get(GemesifVeloGlobal.ThemeColors.GREY05).getColorString();
        String s = GemesifVeloGlobal.colorDayNight_Data.get(key).getColorString();

        // Log.d(DEBUG_TAG, "color string " + s);

        return GemesifVeloGlobal.colorDayNight_Data.get(key).getColorValue();
    }

    void adjustViewGroupBackground(ViewGroup viewGroup, DayNightTheme dayNightTheme, GemesifVeloGlobal.ThemeColors themeColors) {

        // Log.d(DEBUG_TAG, "adjustViewGroupBackground");

        if (dayNightTheme == DayNightTheme.DAY_THEME) {
            viewGroup.setBackgroundColor(getColorDayNight_Data(themeColors));
        } else {
            viewGroup.setBackgroundColor(getColorDayNight_Data(colorDayNightInverse.get(themeColors)));
        }
    }

    void adjustTextView(TextView textView, DayNightTheme dayNightTheme, GemesifVeloGlobal.ThemeColors[] themeColors) {

        // Log.d(DEBUG_TAG, "adjustTextView");

        if (dayNightTheme == DayNightTheme.DAY_THEME) {
            (textView).setBackgroundColor(getColorDayNight_Data(themeColors[0]));
            (textView).setTextColor(getColorDayNight_Data(themeColors[1]));
        } else {
            (textView).setBackgroundColor(getColorDayNight_Data(colorDayNightInverse.get(themeColors[0])));
            (textView).setTextColor(getColorDayNight_Data(colorDayNightInverse.get(themeColors[1])));
        }
    }

    void adjustButton(Button button, DayNightTheme dayNightTheme, GemesifVeloGlobal.ThemeColors[] themeColors) {


        // Button button = (Button) child;

/*
        // hatter nyomva, elengedve
        StateListDrawable states = new StateListDrawable();
        states.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.RED)));
        states.addState(new int[]{}, new ColorDrawable(getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.YELLOW1)));
        button.setBackground(states);

        // szam nyomva, elengedve
        ColorStateList colorStates = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{}}, new int[]{
                getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.BLUE2), getColorDayNight_Data(GemesifVeloGlobal.ThemeColors.SILVER)});
        button.setTextColor(colorStates);

*/
        if (dayNightTheme == DayNightTheme.DAY_THEME) {
            StateListDrawable states = new StateListDrawable();
            states.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(getColorDayNight_Data(themeColors[1])));
            states.addState(new int[]{}, new ColorDrawable(getColorDayNight_Data(themeColors[0])));
            button.setBackground(states);

            ColorStateList colorStates = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{}}, new int[]{
                    getColorDayNight_Data(themeColors[3]), getColorDayNight_Data(themeColors[2])});
            button.setTextColor(colorStates);
        } else {
            StateListDrawable states = new StateListDrawable();
            states.addState(new int[]{android.R.attr.state_pressed}, new ColorDrawable(getColorDayNight_Data(colorDayNightInverse.get(themeColors[1]))));
            states.addState(new int[]{}, new ColorDrawable(getColorDayNight_Data(colorDayNightInverse.get(themeColors[0]))));
            button.setBackground(states);

            ColorStateList colorStates = new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{}}, new int[]{
                    getColorDayNight_Data(colorDayNightInverse.get(themeColors[3])), getColorDayNight_Data(colorDayNightInverse.get(themeColors[2]))});
            button.setTextColor(colorStates);
            }
        }

        public class MyOnTouchListener implements View.OnTouchListener {

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                int action = MotionEventCompat.getActionMasked(event);

                // Log.d(DEBUG_TAG, "FragmentSpeed onTouch");

                return true;

            /*

            switch (action) {
                case (MotionEvent.ACTION_DOWN):
                    // Log.d(DEBUG_TAG, "Action was DOWN");
                    return true;
                case (MotionEvent.ACTION_MOVE):
                    // Log.d(DEBUG_TAG, "Action was MOVE");
                    return true;
                case (MotionEvent.ACTION_UP):
                    // Log.d(DEBUG_TAG, "Action was UP");
                    return true;
                case (MotionEvent.ACTION_CANCEL):
                    // Log.d(DEBUG_TAG, "Action was CANCEL");
                    return true;
                case (MotionEvent.ACTION_OUTSIDE):
                    // Log.d(DEBUG_TAG, "Movement occurred outside bounds " + "of current screen element");
                    return true;
                default:
                    // Log.d(DEBUG_TAG, "default: " + action);
                    return true;
            }

            */
            }
        }

    }
