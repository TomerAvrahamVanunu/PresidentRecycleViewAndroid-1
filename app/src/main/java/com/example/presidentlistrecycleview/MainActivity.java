package com.example.presidentlistrecycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App" ;
    Button btn_addOne;

    //RecyclerView.Adapter mAdapter;
    //RecyclerView recyclerView;
    //private RecyclerView.Adapter mAdapter;
    //RecyclerView.LayoutManager layoutManager;

    List<President> presidentList = new ArrayList<President>();

    // we add here 3 privte for RecyclerView
   private RecyclerView recyclerView;
   private RecyclerView.Adapter mAdapter;
   private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPresidentList();
        Log.d(TAG, "onCreate: " + presidentList.toString());
        Toast.makeText(this, "Presidents count = " + presidentList.size(), Toast.LENGTH_SHORT).show();

        btn_addOne = findViewById(R.id.btn_addOne);


        btn_addOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
//                finish();
            }
        });
        // private RecyclerView recyclerView;
        recyclerView = findViewById(R.id.lv_presidentList);
        // use this setting to improve perfomance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        //private RecyclerView.LayoutManager layoutManager;
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next eample)
        mAdapter = new RecycleViewAdapter(presidentList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788,"https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President(1, "Jhon Adams", 1976, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/160px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg");
        President p2 = new President(2, "Thomas Jefferson", 1800,"https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/160px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3, "Abraham Lincoln", 1860,"https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/160px-Abraham_Lincoln_O-77_matte_collodion_print.jpg");
        President p4 = new President(4, "Ulysses Grant", 1868,"https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Ulysses_S_Grant_by_Brady_c1870-restored.jpg/160px-Ulysses_S_Grant_by_Brady_c1870-restored.jpg");
        President p5 = new President(5, "Theodore Roosevelt", 1900, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/President_Roosevelt_-_Pach_Bros.jpg/160px-President_Roosevelt_-_Pach_Bros.jpg");
        President p6 = new President(6, "Franklin Roosevelt", 1932,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/FDR_1944_Color_Portrait.jpg/160px-FDR_1944_Color_Portrait.jpg");
        President p7 = new President(7, "Harry Truman", 1944, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/TRUMAN_58-766-06_%28cropped%29.jpg/160px-TRUMAN_58-766-06_%28cropped%29.jpg");
        President p8 = new President(8, "Dwight Eisenhower", 1952, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg/160px-Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg");
        President p9 = new President(9, "Ronald Regan", 1980, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Official_Portrait_of_President_Reagan_1981.jpg/160px-Official_Portrait_of_President_Reagan_1981.jpg");

        presidentList.addAll(Arrays.asList(new President[] {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9}));
    }
}