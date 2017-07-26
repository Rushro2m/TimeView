package com.rushro2m.timeview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MyAdapter myAdapter;
    private List<HashMap<String, Object>> listItem;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        listItem = new ArrayList<>();
        HashMap<String, Object> map1 = new HashMap<>();
        HashMap<String, Object> map2 = new HashMap<>();
        HashMap<String, Object> map3 = new HashMap<>();
        HashMap<String, Object> map4 = new HashMap<>();
        HashMap<String, Object> map5 = new HashMap<>();
        HashMap<String, Object> map6 = new HashMap<>();

        map1.put("ItemTitle", "美国谷歌公司已发出");
        map1.put("ItemText", "发件人：李明");
        listItem.add(map1);

        map2.put("ItemTitle", "美国谷歌公司已发出");
        map2.put("ItemText", "发件人：李明");
        listItem.add(map2);

        map3.put("ItemTitle", "美国谷歌公司已发出");
        map3.put("ItemText", "发件人：李明");
        listItem.add(map3);

        map4.put("ItemTitle", "美国谷歌公司已发出");
        map4.put("ItemText", "发件人：李明");
        listItem.add(map4);

        map5.put("ItemTitle", "美国谷歌公司已发出");
        map5.put("ItemText", "发件人：李明");
        listItem.add(map5);

        map6.put("ItemTitle", "美国谷歌公司已发出");
        map6.put("ItemText", "发件人：李明");
        listItem.add(map6);
    }

    private void initView() {

        recyclerView = (RecyclerView) findViewById(R.id.recycler_main);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this));

        myAdapter = new MyAdapter(listItem, this);
        recyclerView.setAdapter(myAdapter);


    }
}
