package com.guidepage3d;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends FragmentActivity {

    private ViewPager mPager;
    private int[] mLayoutIds = new int[] {
        R.layout.frg_first,R.layout.frg_second,R.layout.frg_third
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
        initView();
    }

    private void findView() {
        mPager = (ViewPager) findViewById(R.id.vp);
    }

    private void initView() {
        mPager.setAdapter(new TranslationAdapter(getSupportFragmentManager()));
        //页面滑动监听器
        mPager.setPageTransformer(true,new TranslatePagerTransFormer());
    }


    class TranslationAdapter extends FragmentStatePagerAdapter {

        public TranslationAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mLayoutIds.length;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment f = new TranslateFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("layoutId",mLayoutIds[i]);
            f.setArguments(bundle);
            return f;
        }
    }


}
