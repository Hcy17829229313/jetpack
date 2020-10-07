package com.example.tesy.music;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tesy.R;
import com.example.tesy.egBabyBean.BabyTabListBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;

public class MusicActivity extends AppCompatActivity {

    private ImageView music_bg_img;
    private ImageView music_back;
    private ImageView music_img;
    private TextView music_time_kai;
    private TextView title_music;
    private SeekBar progressBar;
    private TextView music_time_zong;
    private ImageView music_model;
    private ImageView music_pre;
    private ImageView music_Pause;
    private ImageView music_next;
    private ImageView music_timer;


    private IServicer iServicer;
    private boolean pd=false;
    private ObjectAnimator objectAnimator;
    private int duration;
    private int MSG_PROGESS=0;


    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what==MSG_PROGESS){
                // 实时更新进度
                updataProgess();
            }
        }
    };
    private int progess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        EventBus.getDefault().register(this);
        initView();
        initVIewData();
        initData();
    }


    private void initView() {
        music_bg_img = (ImageView) findViewById(R.id.music_bg_img);
        music_back = (ImageView) findViewById(R.id.music_back);
        music_img = (ImageView) findViewById(R.id.music_img);
        music_time_kai = (TextView) findViewById(R.id.music_time_kai);
        progressBar = (SeekBar) findViewById(R.id.progressBar);
        music_time_zong = (TextView) findViewById(R.id.music_time_zong);
        title_music = (TextView) findViewById(R.id.title_music);
        music_model = (ImageView) findViewById(R.id.music_model);
        music_pre = (ImageView) findViewById(R.id.music_pre);
        music_Pause = (ImageView) findViewById(R.id.music_Pause);
        music_next = (ImageView) findViewById(R.id.music_next);
        music_timer = (ImageView) findViewById(R.id.music_timer);

        music_back.setOnClickListener(view -> {
        });



        //因为写在EventBUs中动画会有bug所以需要移动到写在initView方法中
        //无限旋转的动画
        objectAnimator = ObjectAnimator.ofFloat(music_img, "rotation", 0, 360);
        objectAnimator.setRepeatCount(ValueAnimator.INFINITE);
         objectAnimator.setDuration(10000);
         objectAnimator.setInterpolator(new LinearInterpolator());
         objectAnimator.start();


        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean select) {

                if(select){
                    //更新medarplayer进度
                    iServicer.seekTo(i);
                    //更新界面进度
                    updataProgess();
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        music_model.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updataModel();
            }
        });

        music_pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iServicer.playPre();
            }
        });
        music_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iServicer.playNext();
            }
        });

    }

    /*播放时处理*/
    private void updataModel() {
        /*Ser模式的更新*/
            iServicer.ipdatamodel();

            /*图片的更新*/
        updataModelBtn();

    }

    private void updataModelBtn() {

        /*获取Servicer模式下当前模式*/
        int model = iServicer.getModel();

        if ( model== MusicServicer.MODEL_ALL) {
            music_model.setImageLevel(0);
        }else if(model== MusicServicer.MODEL_SINGLE){
            music_model.setImageLevel(1);
        }else if(model== MusicServicer.MODEL_RANDOM){
            music_model.setImageLevel(2);
        }

    }

    private void initVIewData() {
        music_Pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updataPlayBtn();
            }


        });
    }

    /*
    * 更改当前播放状态
    * */
    private void updataPlayBtn() {

        //  更改Seriver中音乐播放状态
    iServicer.getUpDataStuats();

    // 更改图标
        updatabtn();

    }

    private void updatabtn() {
        boolean playing = iServicer.isPlaying();
        if (playing) {
            music_Pause.setSelected(true);
            //点击开始动画
            objectAnimator.resume();

            handler.sendEmptyMessage(MSG_PROGESS);//**

        }else {
            music_Pause.setSelected(false);

            objectAnimator.pause();

            handler.removeMessages(MSG_PROGESS);//**
        }
    }


    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEventData(BabyTabListBean.AudiosBean babyTabListBean) {
        title_music.setText(babyTabListBean.getName());

        if(!pd){
            Glide.with(this)
                    .load(babyTabListBean.getImage())
                    .apply(RequestOptions.bitmapTransform(new BlurTransformation(100,3)))
                    .into(music_bg_img);
            pd=true;
        }
        Glide.with(this).load(babyTabListBean.getImage())
         .apply(RequestOptions.circleCropTransform()).into(music_img);

        updatabtn();

        /* 获取总长度
        * */
        duration = iServicer.getDuration();
        //  * 这只进度条最大值*/
        progressBar.setMax(duration);

        Log.d("time", "onEventData: "+duration);
        updataProgess();

        updataModel();
    }

    private void updataProgess() {
        //回去实时经度
        progess = iServicer.getProgess();

        progressBar.setProgress(progess);
        // 更新进度
        dataProgess(progess);

        handler.sendEmptyMessageDelayed(MSG_PROGESS,1000);
    }

    private void dataProgess(int progess) {

        String time = TimeUtils.timefenUtil(progess);

      //  * 设置当前进度的时间
      //  *
        music_time_kai.setText(time);

        //给总进度赋值
        music_time_zong.setText(TimeUtils.timefenUtil(duration));

    }


    class AudioConnectation implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iServicer= (IServicer) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }

    private AudioConnectation connectation=new AudioConnectation();

    private void initData() {
        Intent intent = getIntent();
        intent.setClass(this, MusicServicer.class);
        bindService(intent,connectation, Context.BIND_AUTO_CREATE);
        startService(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connectation);
        EventBus.getDefault().unregister(this);
        handler.removeCallbacksAndMessages(null);
    }
}
