package com.abdulwahabfaiz.task;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.abdulwahabfaiz.task.adapter.MyListAdapter;
import com.abdulwahabfaiz.task.dataclass.MyListData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<MyListData> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                arrayList.add(new MyListData("Bid One", android.R.drawable.ic_dialog_email,10000));
                arrayList.add(new MyListData("Bid Two", android.R.drawable.ic_dialog_email,120000));
                arrayList.add(new MyListData("Bid Three", android.R.drawable.ic_dialog_info,180000));
                arrayList.add(new MyListData("Bid Four", android.R.drawable.ic_delete,30000));



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(arrayList, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}