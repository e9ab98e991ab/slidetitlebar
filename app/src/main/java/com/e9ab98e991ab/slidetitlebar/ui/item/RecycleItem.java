package com.e9ab98e991ab.slidetitlebar.ui.item;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.android.databinding.library.baseAdapters.BR;
import com.e9ab98e991ab.slidetitlebar.R;
import com.e9ab98e991ab.slidetitlebar.ui.adapter.BindingAdapterItem;



public class RecycleItem extends BaseObservable implements BindingAdapterItem {
    private Activity mActivity;

    @Override
    public int getViewType() {
        return R.layout.item_recycle;
    }

    private String text;



    public RecycleItem(String text) {
        this.text = text;
    }
    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }




}
