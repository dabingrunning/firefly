package com.dabing.firefly.photopicker;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.dabing.firefly.R;

/**
 * Created by dabing on 2017/11/10.
 * 现在的对话框都是使用什么来写的？
 */

public class BottomPickerDialog  extends AlertDialog{
    private Context mContext;
    public BottomPickerDialog(Context context) {
        super(context);
        mContext = context;
    }

    public void show(){
        Builder builder = new Builder(mContext);
        View view = LayoutInflater.from(mContext).inflate(R.layout.bottom_dialog, null);
        AlertDialog alertDialog = builder.create();
        Window window = alertDialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        //这一行是为了保证宽高显示正常，不写的话在某些主题上宽高显示不正常
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        alertDialog.setContentView(view);
        //在调用了show()方法之后才能设置宽高
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = WindowManager.LayoutParams.MATCH_PARENT;
        attributes.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(attributes);
        window.getDecorView().setPadding(0, 0, 0, 0);
    }

}
