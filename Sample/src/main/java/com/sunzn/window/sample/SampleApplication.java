package com.sunzn.window.sample;

import android.app.Application;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import com.sunzn.window.library.FloatWindow;
import com.sunzn.window.library.LogUtil;
import com.sunzn.window.library.MoveType;
import com.sunzn.window.library.PermissionListener;
import com.sunzn.window.library.Screen;
import com.sunzn.window.library.ViewStateListener;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.icon);

        FloatWindow
                .with(getApplicationContext())
                .setView(imageView)
                .setWidth(Screen.width, 0.2f) //设置悬浮控件宽高
                .setHeight(Screen.width, 0.2f)
                .setX(Screen.width, 0.8f)
                .setY(Screen.height, 0.3f)
                .setMoveType(MoveType.slide, 100, -100)
                .setMoveStyle(500, new BounceInterpolator())
//                .setFilter(true, A_Activity.class, C_Activity.class)
                .setViewStateListener(mViewStateListener)
                .setPermissionListener(mPermissionListener)
                .setDesktopShow(true)
                .setInitDisplay(false)
                .build();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SampleApplication.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {
            LogUtil.d("onSuccess");
        }

        @Override
        public void onFailure() {
            LogUtil.d("onFailure");
        }
    };

    private ViewStateListener mViewStateListener = new ViewStateListener() {
        @Override
        public void onPositionUpdate(int x, int y) {
            LogUtil.d("onPositionUpdate: x=" + x + " y=" + y);
        }

        @Override
        public void onShow() {
            LogUtil.d("onShow");
        }

        @Override
        public void onHide() {
            LogUtil.d("onHide");
        }

        @Override
        public void onDismiss() {
            LogUtil.d("onDismiss");
        }

        @Override
        public void onMoveAnimStart() {
            LogUtil.d("onMoveAnimStart");
        }

        @Override
        public void onMoveAnimEnd() {
            LogUtil.d("onMoveAnimEnd");
        }

        @Override
        public void onBackToDesktop() {
            LogUtil.d("onBackToDesktop");
        }
    };

}
