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


                arrayList.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
                arrayList.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
                arrayList.add(new MyListData("Info", android.R.drawable.ic_dialog_info));
                arrayList.add(new MyListData("Delete", android.R.drawable.ic_delete));
                arrayList.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
                arrayList.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
                arrayList.add(new MyListData("Map", android.R.drawable.ic_dialog_map));
                arrayList.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
                arrayList.add(new MyListData("Info", android.R.drawable.ic_dialog_info));
                arrayList.add(new MyListData("Delete", android.R.drawable.ic_delete));
                arrayList.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
                arrayList.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
                arrayList.add(new MyListData("Map", android.R.drawable.ic_dialog_map));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        MyListAdapter adapter = new MyListAdapter(arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}