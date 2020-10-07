package com.example.tesy.egui;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tesy.R;
import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;
import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

public class LookRecActivity extends AppCompatActivity {

    private StandardGSYVideoPlayer video_player;
    private String mp4;
    private String title;
    private OrientationUtils orientationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look);
        mp4 = getIntent().getStringExtra("mp44");
        title = getIntent().getStringExtra("titlee");
        initView();

        Log.d("mmm", "onCreate: "+mp4+"onCreate"+title);

    }

    private void initView() {
        video_player = (StandardGSYVideoPlayer) findViewById(R.id.video_player);

        video_player.setUp(mp4,true,title);

        Log.d("eee", "initView: "+mp4);
        //增加封面
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageResource(R.mipmap.icon_back);
        video_player.setThumbImageView(imageView);
        //增加title
        video_player.getTitleTextView().setVisibility(View.VISIBLE);
        //设置返回键
        video_player.getBackButton().setVisibility(View.VISIBLE);
        //设置旋转
        orientationUtils = new OrientationUtils(this, video_player);
        //设置全屏按键功能,这是使用的是选择屏幕，而不是全屏
        video_player.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                orientationUtils.resolveByClick();
            }
        });

        //是否可以滑动调整
        video_player.setIsTouchWiget(true);
        //设置返回按键功能
        video_player.getBackButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        video_player.startPlayLogic();
    }

    @Override
    protected void onPause() {
        super.onPause();
        video_player.onVideoPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        video_player.onVideoResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        GSYVideoManager.releaseAllVideos();
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onBackPressed() {
        //先返回正常状态
        if (orientationUtils.getScreenType() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
            video_player.getFullscreenButton().performClick();
            return;
        }
        //释放所有
        video_player.setVideoAllCallBack(null);
        super.onBackPressed();
    }
}
