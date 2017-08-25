package com.lifecycle.activity.lifecycleofactivity.utils;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;

/**
 * Created by Kapil Rajput on 25-Aug-17.
 */
public class DeprecateCheck {

    public static final int getColor(int id, Context context) {
        final int version = Build.VERSION.SDK_INT;
        if (version >= 23) {
            return ContextCompat.getColor(context, id);
        } else {
            return context.getResources().getColor(id);
        }
    }
}
