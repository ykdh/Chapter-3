package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ListView;


import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {

    private ListView listView;
    private LottieAnimationView animationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件

        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        animationView=getView().findViewById(R.id.animation_view1);
        listView=getView().findViewById(R.id.list_numbers);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入

                //淡出
                AnimationSet animationSet=new AnimationSet(true);
                AlphaAnimation alpha=new AlphaAnimation(1,0);
                alpha.setDuration(1000);
                animationSet.addAnimation(alpha);
                animationView.startAnimation(animationSet);
                animationView.setVisibility(View.INVISIBLE);
                //淡入
                AnimationSet animationSet1=new AnimationSet(true);
                AlphaAnimation alpha1=new AlphaAnimation(0,1);
                alpha1.setDuration(1000);
                animationSet1.addAnimation(alpha1);
                listView.startAnimation(animationSet1);
                listView.setVisibility(View.VISIBLE);

            }
        }, 5000);
    }
}
