package com.example.tesy.music;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

import com.example.tesy.egBabyBean.BabyTabListBean;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MusicServicer extends Service {

    private MusicAudio musicAudio;
    private ArrayList<BabyTabListBean> list;
    private int posi;
    private SharedPreferences sharedPreferences;

    public MusicServicer(){
    }
    @Override
    public void onCreate() {
        musicAudio = new MusicAudio();

        sharedPreferences = getSharedPreferences("sp", MODE_PRIVATE);

        //获取保存状态
        MusicServicer.model=sharedPreferences.getInt("model",MODEL_ALL);

        super.onCreate();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return musicAudio;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        list = (ArrayList<BabyTabListBean>) intent.getSerializableExtra("list");
        posi = intent.getIntExtra("posi", -3);

        musicAudio.PlayItem();
        return super.onStartCommand(intent, flags, startId);
    }


    // 全屏播放
    public static int MODEL_ALL = 1;
    // 单曲播放
    public static int MODEL_SINGLE = 2;
    // 随机播放
    public static int MODEL_RANDOM = 3;
    // 当前的模式播放
    public static int model=MODEL_ALL;

    class MusicAudio extends Binder implements IServicer {
        private MediaPlayer mediaPlayer;

        /*
         * 播放条目音乐
         * */
        @Override
        public void PlayItem() {


            if(mediaPlayer!=null){
                //重置
                mediaPlayer.reset();
//释放
                mediaPlayer.release();
//赋值为null
                mediaPlayer=null;
            }
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(list.get(posi).getAudios().get(posi).getResource());
            } catch (Exception e) {
                e.printStackTrace();
            }
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mediaPlayer.start();

                    // 当音乐真正开始播放
                    notfiupdataui();
                }
            });

            // 当音乐结束播放时候回调

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    adtuNext();
                }

            });

            //异步
            mediaPlayer.prepareAsync();
        }

        /*
         * 播放下一首*/
        private void adtuNext() {
            if (model == MODEL_ALL) {
                //全部播放
                posi = (posi + 1) % list.size();
                PlayItem();
            } else if (model == MODEL_SINGLE) {

            } else if (model == MODEL_RANDOM) {
                /*随机播放  */
                mediaPlayer.release();
                Random random = new Random();
                posi = random.nextInt(list.size());
                PlayItem();

            }
        }

        /*
         * 返回当前播放状态
         * */
        @Override
        public void getUpDataStuats() {
            if (isPlaying()) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.start();
            }
        }

        /*
         * 更新ui*/
        private void notfiupdataui() {
            EventBus.getDefault().postSticky(list.get(posi).getAudios().get(posi));
        }

        /*
         * 返回当前播放状态
         * */
        @Override
        public boolean isPlaying() {
            return mediaPlayer.isPlaying();
        }

        /*
         * 返回音乐总长度
         * */
        @Override
        public int getDuration() {
            return mediaPlayer.getDuration();
        }

        /**
         * 获取当前音乐比方的经度
         **/
        @Override
        public int getProgess() {
            return mediaPlayer.getCurrentPosition();
        }

        /*
         * 更新音乐进度
         * */
        @Override
        public void seekTo(int i) {
            mediaPlayer.seekTo(i);
        }

        /*播放模式处理*/
        @Override
        public void ipdatamodel() {

            if (model == MODEL_ALL) {
                model = MODEL_SINGLE;
            } else if (model == MODEL_SINGLE) {
                model = MODEL_RANDOM;
            } else if (model == MODEL_RANDOM) {
                model = MODEL_ALL;
            }
            sharedPreferences.edit().putInt("model", model).commit();
        }

        /*
         * 返回当前模式*/
        @Override
        public int getModel() {
            return model;
        }

        @Override
        public void playPre() {
            //获取播放下标
            if (model == MODEL_RANDOM) {
                //点击上一首还是随机播放
                Random random = new Random();
                posi = random.nextInt(list.size());
                PlayItem();
            } else {
                //其他两中是播放上一首
                if (posi == 0) {
                    //如果是第一首则变成最后一首
                    posi = list.size() - 1;
                } else {
                    posi--;
                    PlayItem();

                }
            }
        }

        @Override
        public void playNext() {
            if (model == MODEL_RANDOM) {
                //如果是随机,跟播放上一曲一样
                Random random = new Random();
                posi = random.nextInt(list.size());
                PlayItem();
            }else {
                posi=(posi+1)%list.size();

                PlayItem();

            }
        }
    }
}
