package com.guidepage3d;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by wangzhiguo on 15/9/6.
 */
public class TranslatePagerTransFormer implements ViewPager.PageTransformer {
    /**
     * 当我们的Viewpager滑动的时候，每个页面都会回调这个方法
     * @param view 某个页面对应的视图－－－布局的视图
     * @param position：位置
     */
    @Override
    public void transformPage(View view, float position) {
        //判断区间,渐变效果position(-1,1)
        if(position < 1 && position > -1) {
            //视差加速效果,让里面的所有的子控件都给一个加速偏移量
            ViewGroup rl = (ViewGroup) view.findViewById(R.id.rl);
            for(int i = 0;i < rl.getChildCount();i++) {
                View child =  rl.getChildAt(i);
                //加速偏移量（在child原来的位置上再加一个偏移值）
                float factor = (float) (Math.random() * 2);
                if(child.getTag() == null) {
                    child.setTag(factor);
                } else {
                    factor = (float)child.getTag();
                }
                child.setTranslationX(position * factor * child.getWidth());
            }
            //缩放的范围0～1
            rl.setScaleX((float)Math.max(0.8,1 - Math.abs(position)));
            rl.setScaleY((float)Math.max(0.8,1 - Math.abs(position)));

            //3D翻转动画
            rl.setPivotX(position < 0 ? rl.getWidth() : 0f);
            rl.setPivotY(rl.getHeight() * 0.5f);
            rl.setRotationY(position * 90);
            //3D内侧翻转
//            rl.setPivotX(position < 0 ? rl.getWidth() : 0f);
//            rl.setPivotY(rl.getHeight() * 0.5f);
//            rl.setRotationY(-position * 90);
            //绕自己翻转
//            rl.setPivotX(rl.getHeight() * 0.5f);
//            rl.setPivotY(rl.getHeight() * 0.5f);
//            rl.setRotationY(-position * 90);
        }

    }
}
