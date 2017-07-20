package com.example.android.timerangepicker;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.NumberPicker;

import java.lang.reflect.Field;

/**
 * Created by prash on 7/20/2017.
 */

public class TimeNumberPicker extends NumberPicker {

    public TimeNumberPicker(Context context, AttributeSet attrs) {
        super(context, attrs);

        Class<?> numberPickerClass = null;
        try {
            numberPickerClass = Class.forName("android.widget.NumberPicker");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field selectionDivider = null;
        Field height = null;
        Field pad = null;
        try {
            selectionDivider = numberPickerClass.getDeclaredField("mSelectionDivider");
            height = numberPickerClass.getDeclaredField("mMinHeight");
            pad = numberPickerClass.getDeclaredField("mMaxHeight");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        try {
            selectionDivider.setAccessible(true);
            selectionDivider.set(this, null);
            height.setAccessible(true);
            height.set(this,400);
            pad.setAccessible(true);
            pad.set(this,400);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

