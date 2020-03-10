package com.shixun;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.shixun.base.BaseActivity;
import com.shixun.interfaces.test.TestConstract;
import com.shixun.model.bean.ChaptersBean;
import com.shixun.persenter.test.TestPersenter;

import static com.shixun.interfaces.test.TestConstract.*;

public class TestActivity extends BaseActivity<TestConstract.Persenter> implements TestConstract.View {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    };

    @Override
    protected int getLayout() {
        return R.layout.activity_test;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        persenter.getChapters();
    }

    @Override
    protected TestConstract.Persenter createPersenter() {
        return new TestPersenter();
    }

    @Override
    public void getChaptersReturn(ChaptersBean result) {
        Log.i("Test",result.getData().toString());

        Message msg = new Message();
        msg.what = 1;
        msg.obj = "error";
        handler.sendMessage(msg);
    }
}
