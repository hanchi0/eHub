package com.jaemion.eHub;

import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;

import androidx.databinding.BindingConversion;
import androidx.lifecycle.LiveData;

public class BindingCollection {


    @androidx.databinding.BindingAdapter("android:text")
    public static void setText(EditText view, LiveData<String> value) {
        view.setText(value.getValue());
    }

    @BindingConversion
    public static ColorDrawable convertColorToDrawable(int color) {
        return new ColorDrawable(color);
    }
}
