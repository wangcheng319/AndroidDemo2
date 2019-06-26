package com.example.wangc.androiddemo;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);

        List<String> datas = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            datas.add(""+i);
        }
        final RecyclerView recyclerView = findViewById(R.id.rv);
        MyAdapter myAdapter = new MyAdapter(this,datas);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        final EditText editText = findViewById(R.id.ed);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int bottom = linearLayoutManager.findLastVisibleItemPosition();
                int first = linearLayoutManager.findFirstVisibleItemPosition();

                recyclerView.scrollToPosition(Integer.valueOf(editText.getText().toString().trim()));

                recyclerView.scrollBy(0, recyclerView.getChildAt(bottom-first).getTop());
            }
        });
    }
}
