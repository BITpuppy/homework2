package chapter.android.aweme.ss.com.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 大作业:实现一个抖音消息页面,所需资源已放在res下面
 */
public class Exercises3 extends AppCompatActivity {
    private ListView list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setTitle("Exercises3");
        list = (ListView)findViewById(R.id.list);
        ArrayList<HashMap<String, Object>> listItem = new ArrayList<HashMap<String,Object>>();
        String[] ItemTitle = new String[] {"游戏小助手","抖音小助手","系统信息","我是豆豆啊哇塞","陌生人信息","喂喂卫","李垭超","tesyyu"};
        String[] ItemText = new String[] {"抖出好游戏","#收下我的双下巴祝福","账号登陆提醒","转发[视频]","test1:转发[直播]:七舅脑爷","[Hi]","转发[视频]","我是tesyyu,让我们开始聊天吧"};
        String[] ItemTime = new String[] {"刚刚","昨天","12-28","12-21","12-12","12-04","11-01","10-19"};
        for(int i=0;i<8;i++)
        {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.icon_girl);
            map.put("ItemTitle", ItemTitle[i]);
            map.put("ItemText", ItemText[i]);
            map.put("ItemTime",ItemTime[i]);
            listItem.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,listItem,R.layout.im_list_item,new String[] {"ItemImage","ItemTitle", "ItemText","ItemTime"},
                new int[] {R.id.robot_notice,R.id.tv_title,R.id.tv_description,R.id.tv_time});
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("data", position);
                intent.setClass(Exercises3.this, Item1.class);
                Exercises3.this.startActivity(intent);
            }
        });
    }
}