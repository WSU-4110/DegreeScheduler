package com.DegreeSchedulerApp.degreescheduler;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
//import androidx.test.core.app.ApplicationProvider;

import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfo;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoAdapter;
import com.DegreeSchedulerApp.degreescheduler.Data.ClassInfoDatabase;

import java.util.List;

public class CreateSchedule extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_schedule);

        recyclerView = findViewById(R.id.recycler_view);

        //allow database to use main thread (bad)
        //enables database
        ClassInfoDatabase classInfoDatabase = Room.databaseBuilder(this,
                ClassInfoDatabase.class, "CLASS_INFO.db").allowMainThreadQueries().build();

        //add all classes to this list, this query gives all the information
        List<ClassInfo> classInfoList = classInfoDatabase.getClassInfoDao().getAll();

        //enable recycler view
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ClassInfoAdapter(classInfoList);
        recyclerView.setAdapter(adapter);


    }
}
