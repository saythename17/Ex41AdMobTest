package com.icandothisallday2020.ex41admobtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.rewarded.RewardedAd;

public class ThirdActivity extends AppCompatActivity {
    //보상형 광고
    RewardedVideoAd rewardedAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        //Reward 광고 객체 생성//Advertising
        rewardedAd= MobileAds.getRewardedVideoAdInstance(this);
        //리스너 추가(로드가 끝나면 광고가 나오도록)
        rewardedAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                rewardedAd.show();
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            //동영상시청후 보상받을때 자동실행
            @Override
            public void onRewarded(RewardItem rewardItem) {
                String type=rewardItem.getType();
                int cnt=rewardItem.getAmount();
                Toast.makeText(ThirdActivity.this, "+"+cnt+type, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {

            }

            @Override
            public void onRewardedVideoCompleted() {

            }
        });

        //리워드 비디오 광고 요청과 함께 광고단위 ID 지정
        AdRequest adRequest=new AdRequest.Builder().build();
        rewardedAd.loadAd("ca-app-pub-2102574529234286/8626998394",adRequest);
    }

    public void clickReward(View view) {
        AdRequest adRequest=new AdRequest.Builder().build();
        rewardedAd.loadAd("ca-app-pub-2102574529234286/8626998394",adRequest);
    }
}
