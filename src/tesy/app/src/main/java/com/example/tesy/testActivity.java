package com.example.tesy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.httplibrary.utils.LogUtils;
import com.example.tesy.test.ImageUtils;
import com.example.tesy.test.MyImageLoader;

import java.io.IOException;
import java.lang.ref.WeakReference;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class testActivity extends AppCompatActivity {
    private static String imgUrl = "http://ww1.sinaimg.cn/large/0065oQSqly1fsfq2pwt72j30qo0yg78u.jpg";
    private static final int SUCCESS = 0x0001;
    private static final int FAIL = 0x0002;
    private MyHandler mHandler;
    private static ImageView mImageView;
    private static MyImageLoader mImageLoader;
    private Button mBt_load;

    static class MyHandler extends Handler {
        //创建一个类继承 Handler
        WeakReference<AppCompatActivity> mWeakReference;

        public MyHandler(AppCompatActivity activity) {
            mWeakReference = new WeakReference<>(activity);
        }

        //在 handleMessage 方法中对网络下载的图片进行处理
        @Override
        public void handleMessage(Message msg) {
            final AppCompatActivity appCompatActivity = mWeakReference.get();
            if (appCompatActivity != null) {
                switch (msg.what) {
                    case SUCCESS://成功
                        byte[] Picture = (byte[]) msg.obj;
                        Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);
                        mImageLoader.addBitmap(ImageUtils.hashKeyForCache(imgUrl), bitmap);
                        mImageView.setImageBitmap(bitmap);

                        break;
                    case FAIL://失败

                        break;
                }

            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        //创建 Handler
        mHandler = new MyHandler(this);
        mImageView = findViewById(R.id.iv_lrucache);
        //创建自定义的图片加载类
        mImageLoader = new MyImageLoader();
        mBt_load = findViewById(R.id.bt_load);
        //点击按钮进行图片加载
        mBt_load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = getBitmapFromCache();
                if (bitmap != null) {//有缓存
                    LogUtils.e("从缓存中取出图片");
                    mImageView.setImageBitmap(bitmap);
                } else {//没有缓存
                    LogUtils.e("从网络下载图片");
                    downLoadBitmap();
                }
            }
        });

    }

    /**
     * 从缓存中获取图片
     *
     * @return
     */
    private Bitmap getBitmapFromCache() {
        return mImageLoader.getBitmap(ImageUtils.hashKeyForCache(imgUrl));
    }

    /**
     * 从网络上下载图片
     * 使用 OKHttp 进行图片的下载
     */
    private void downLoadBitmap() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(imgUrl)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                byte[] Picture_bt = response.body().bytes();
                Message message = mHandler.obtainMessage();
                message.obj = Picture_bt;
                message.what = SUCCESS;
                mHandler.sendMessage(message);

            }
        });

    }
}
