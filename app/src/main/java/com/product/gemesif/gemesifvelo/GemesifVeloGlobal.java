package com.product.gemesif.gemesifvelo;

import android.util.Log;

import org.jetbrains.annotations.Contract;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Pattern;

public class GemesifVeloGlobal {

    public enum DayNightTheme {
        NIGHT_THEME, DAY_THEME
    }

    public enum AppearanceType {
        NORMAL, BLACKBACKGROUNDSEP, SEP, NOTAG
    }

    public static  ThemeColors AppearanceColorBackground(AppearanceType appearanceType) {

        switch (appearanceType) {
            case NORMAL:
                return ThemeColors.BACKGROUND;
            case NOTAG:
                return ThemeColors.BACKGROUND;
            case BLACKBACKGROUNDSEP:
                return ThemeColors.SEPBLACKBACKGROUND;
            case SEP:
                return ThemeColors.BACKGROUND;
        }

        return ThemeColors.SILVER;

    };

    @Contract(pure = true)
    public static  ThemeColors [] AppearanceColorTextView(AppearanceType appearanceType) {

        ThemeColors [] themeColors = new ThemeColors[2];

        switch (appearanceType) {
            case NORMAL:
                themeColors[0] = ThemeColors.BACKGROUND;
                themeColors[1] = ThemeColors.FONTCOLOR;
                return themeColors;
            case SEP:
                themeColors[0] = ThemeColors.BACKGROUND;
                themeColors[1] = ThemeColors.SEPFONTCOLOR;
                return themeColors;
        }

        return themeColors;

    };

    @Contract(pure = true)
    public static  ThemeColors [] AppearanceColorButton() {


        ThemeColors [] themeColors = new ThemeColors[4];

        themeColors[0] = ThemeColors.BUTTONBACKGROUND;
        themeColors[1] = ThemeColors.PUSH_BUTTONBACKGROUND;
        themeColors[2] = ThemeColors.BUTTONFONTCOLOR;
        themeColors[3] = ThemeColors.PUSH_BUTTONFONTCOLOR;


        return themeColors;
    };



    // public static DayNightTheme currentDayNightTheme = DayNightTheme.DAY_THEME;
    public static DayNightTheme currentDayNightTheme = DayNightTheme.NIGHT_THEME;

    public static String themeColors[] = {"fontColor", "inverse_fontColor", "sepfontcolor", "inverse_sepfontcolor", "fontColor_darkbackground", "inverse_fontColor_darkbackground", "background", "inverse_background", "darkbackground", "inverse_darkbackground",
            "buttonbackground", "inverse_buttonbackground",
            "push_buttonbackground", "inverse_push_buttonbackground",
            "buttonfontcolor", "inverse_buttonfontcolor",
            "push_buttonfontcolor", "inverse_push_buttonfontcolor",
            "silver"};

    public enum ThemeColors {
        FONTCOLOR, INVERSE_FONTCOLOR, FONTCOLOR_DARKBACKGROUND, INVERSE_FONTCOLOR_DARKBACKGROUND, SEPFONTCOLOR, INVERSE_SEPFONTCOLOR, BACKGROUND, INVERSE_BACKGROUND, DARKBACKGROUND, INVERSE_DARKBACKGROUND, SEPBLACKBACKGROUND, INVERSE_SEPBLACKBACKGROUND,

        BUTTONBACKGROUND, INVERSE_BUTTONBACKGROUND,
        PUSH_BUTTONBACKGROUND, INVERSE_PUSH_BUTTONBACKGROUND,
        BUTTONFONTCOLOR, INVERSE_BUTTONFONTCOLOR,
        PUSH_BUTTONFONTCOLOR, INVERSE_PUSH_BUTTONFONTCOLOR,



        WHITE, BlACK, GREY05, RED, YELLOW1, AQUA, BLUE2, SILVER
    }

    public static class ColorTable {
        String colorString;
        Integer colorValue;

        ColorTable(String s, int i){
            this.colorString = s;
            this.colorValue = i;
        }

        ColorTable(String s){
            this.colorString = s;
            this.colorValue = null;
        }

        public String getColorString() {
            return colorString;
        }

        public int getColorValue() {
            return colorValue;
        }

        public void setColorString(String colorString) {
            this.colorString = colorString;
        }

        public void setColorValue(int colorValue) {
            this.colorValue = colorValue;
        }
    }

    public static Hashtable<ThemeColors, ThemeColors> colorDayNightInverse = new Hashtable<ThemeColors, ThemeColors>();
    static {
        colorDayNightInverse.put(ThemeColors.FONTCOLOR, ThemeColors.INVERSE_FONTCOLOR);
        colorDayNightInverse.put(ThemeColors.FONTCOLOR_DARKBACKGROUND, ThemeColors.INVERSE_FONTCOLOR_DARKBACKGROUND);
        colorDayNightInverse.put(ThemeColors.SEPFONTCOLOR, ThemeColors.INVERSE_SEPFONTCOLOR);
        colorDayNightInverse.put(ThemeColors.BACKGROUND, ThemeColors.INVERSE_BACKGROUND);
        colorDayNightInverse.put(ThemeColors.DARKBACKGROUND, ThemeColors.INVERSE_BACKGROUND);
        colorDayNightInverse.put(ThemeColors.SEPBLACKBACKGROUND, ThemeColors.INVERSE_SEPBLACKBACKGROUND);

        colorDayNightInverse.put(ThemeColors.BUTTONBACKGROUND, ThemeColors.INVERSE_BUTTONBACKGROUND);
        colorDayNightInverse.put(ThemeColors.PUSH_BUTTONBACKGROUND, ThemeColors.INVERSE_PUSH_BUTTONBACKGROUND);
        colorDayNightInverse.put(ThemeColors.BUTTONFONTCOLOR, ThemeColors.INVERSE_BUTTONFONTCOLOR);
        colorDayNightInverse.put(ThemeColors.PUSH_BUTTONFONTCOLOR, ThemeColors.INVERSE_PUSH_BUTTONFONTCOLOR);



    }

public static Hashtable<ThemeColors, ColorTable> colorDayNight_Data = new Hashtable<ThemeColors, ColorTable>();
        static {
            colorDayNight_Data.put(ThemeColors.FONTCOLOR, new ColorTable("fontColor")); colorDayNight_Data.put(ThemeColors.INVERSE_FONTCOLOR, new ColorTable("inverse_fontColor"));
            colorDayNight_Data.put(ThemeColors.FONTCOLOR_DARKBACKGROUND, new ColorTable("fontColor_darkbackground")); colorDayNight_Data.put(ThemeColors.INVERSE_FONTCOLOR_DARKBACKGROUND, new ColorTable("inverse_fontColor_darkbackground"));
            colorDayNight_Data.put(ThemeColors.SEPFONTCOLOR, new ColorTable("sepfontcolor")); colorDayNight_Data.put(ThemeColors.INVERSE_SEPFONTCOLOR, new ColorTable("inverse_sepfontcolor"));
            colorDayNight_Data.put(ThemeColors.BACKGROUND, new ColorTable("background")); colorDayNight_Data.put(ThemeColors.INVERSE_BACKGROUND, new ColorTable("inverse_background"));
            colorDayNight_Data.put(ThemeColors.DARKBACKGROUND,  new ColorTable("background")); colorDayNight_Data.put(ThemeColors.INVERSE_DARKBACKGROUND,  new ColorTable("inverse_background"));
            colorDayNight_Data.put(ThemeColors.SEPBLACKBACKGROUND,  new ColorTable("sepblackbackground")); colorDayNight_Data.put(ThemeColors.INVERSE_SEPBLACKBACKGROUND,  new ColorTable("inverse_sepblackbackground"));



            colorDayNight_Data.put(ThemeColors.BUTTONBACKGROUND, new ColorTable("buttonbackground"));
            colorDayNight_Data.put(ThemeColors.INVERSE_BUTTONBACKGROUND, new ColorTable("inverse_buttonbackground"));
            colorDayNight_Data.put(ThemeColors.PUSH_BUTTONBACKGROUND, new ColorTable("push_buttonbackground"));
            colorDayNight_Data.put(ThemeColors.INVERSE_PUSH_BUTTONBACKGROUND, new ColorTable("inverse_push_buttonbackground"));
            colorDayNight_Data.put(ThemeColors.BUTTONFONTCOLOR, new ColorTable("buttonfontcolor"));
            colorDayNight_Data.put(ThemeColors.INVERSE_BUTTONFONTCOLOR, new ColorTable("inverse_buttonfontcolor"));
            colorDayNight_Data.put(ThemeColors.PUSH_BUTTONFONTCOLOR, new ColorTable("push_buttonfontcolor"));
            colorDayNight_Data.put(ThemeColors.INVERSE_PUSH_BUTTONFONTCOLOR, new ColorTable("inverse_push_buttonfontcolor"));






            colorDayNight_Data.put(ThemeColors.WHITE, new ColorTable("white"));
            colorDayNight_Data.put(ThemeColors.BlACK, new ColorTable("black"));
            colorDayNight_Data.put(ThemeColors.GREY05, new ColorTable("grey05"));
            colorDayNight_Data.put(ThemeColors.RED, new ColorTable("red"));
            colorDayNight_Data.put(ThemeColors.YELLOW1, new ColorTable("yellow1"));
            colorDayNight_Data.put(ThemeColors.AQUA, new ColorTable("aqua"));
            colorDayNight_Data.put(ThemeColors.BLUE2, new ColorTable("blue2"));
            colorDayNight_Data.put(ThemeColors.SILVER, new ColorTable("silver"));
        }

    public static Hashtable<AppearanceType, String> appearanceTypeStringRegexp = new Hashtable<AppearanceType, String>();
    static {
        appearanceTypeStringRegexp.put(AppearanceType.BLACKBACKGROUNDSEP, "(.+/)(.+_TAG_BlackBgSep)$");
        appearanceTypeStringRegexp.put(AppearanceType.SEP, "(.+/)(.+_TAG_Sep)$");
        appearanceTypeStringRegexp.put(AppearanceType.NOTAG, "(?!.*_TAG_).*");
        appearanceTypeStringRegexp.put(AppearanceType.NORMAL, appearanceTypeStringRegexp.get(AppearanceType.NOTAG));
    }

    public static Pattern patternSEP = Pattern.compile(appearanceTypeStringRegexp.get(AppearanceType.SEP));
    public static Pattern patternBLACKBACKGROUNDSEP = Pattern.compile(appearanceTypeStringRegexp.get(AppearanceType.BLACKBACKGROUNDSEP));
    public static Pattern patternNOTAG = Pattern.compile(appearanceTypeStringRegexp.get(AppearanceType.NOTAG));
    public static Pattern patternNORMAL = Pattern.compile(appearanceTypeStringRegexp.get(AppearanceType.NORMAL));

}
