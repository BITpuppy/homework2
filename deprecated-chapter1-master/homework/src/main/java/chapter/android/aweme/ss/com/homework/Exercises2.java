package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Exercises2");
        View inflate = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        int ans=getViewCount(inflate);
        Toast.makeText(getApplicationContext(),"ViewCount:"+ans,Toast.LENGTH_LONG).show();
    }

    public static int getViewCount(View view) {
        int count=0,num=((ViewGroup)view).getChildCount();
        if(view instanceof ViewGroup){
            count++;
            for(int i=0;i<num;i++){
                View child=((ViewGroup)view).getChildAt(i);
                if(child instanceof ViewGroup){
                    count += getViewCount(child);
                }
                else{
                    count++;
                }
            }
        }
        return count;
    }
}
