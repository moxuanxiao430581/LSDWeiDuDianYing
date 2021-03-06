package com.bw.movie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

public class GuidePageActivity extends AppCompatActivity {

    private Button bt;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guidepageactivity_main);
        initViews();
        initData();
    }

    private void initViews() {
        bt = findViewById(R.id.guidebt);
        //添加沉浸式
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
    }

    private void initData() {
        handler = new Handler();
        //handler机制
        handler.postDelayed(runnable=new Runnable() {
            @Override
            public void run() {
                //五秒后跳转
                Intent intent = new Intent(GuidePageActivity.this, LoginActivity.class);
                //跳转
                startActivity(intent);
                //关闭销毁页面
                finish();
            }
        },5000);//延迟五秒跳转

        //点击跳转
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuidePageActivity.this,LoginActivity.class);
                //跳转
                startActivity(intent);
                finish();
                if (runnable!=null){
                    //如果是点击状态就删除这个回调方法   删除线程
                    handler.removeCallbacks(runnable);
                }

            }
        });
    }
}
