package com.example.learnfromcodinginflow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <ItemExample> itemExamples;
    private Button insert;
    private Button remove;
    private RecyclerView mrecycleview;
    private RecyclerView.Adapter madapter;
    private RecyclerView.LayoutManager mlayoutManager;
    private EditText editInsert;
    private EditText editDelete;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatingList();
        createRecyleView();

        insert=findViewById(R.id.button_insert);
        remove=findViewById(R.id.button_remove);
        editInsert=findViewById(R.id.edittext_insert);
        editDelete=findViewById(R.id.edittext_remove);


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int position=Integer.parseInt(editInsert.getText().toString());
                    InsertItem(position);
                }
                catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Enter a Number ",Toast.LENGTH_LONG).show();
                }
            }
        });


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int position=Integer.parseInt(editDelete.getText().toString());
                    RemoveItem(position);
                }
              catch (NumberFormatException e){
                    Toast.makeText(getApplicationContext(),"Enter a Number",Toast.LENGTH_LONG).show();
              }
            }
        });

     }

    private void RemoveItem(int position) {
        itemExamples.remove(position);
        madapter.notifyItemRemoved(position);
    }

    private void InsertItem(int position) {
        itemExamples.add(new ItemExample(R.drawable.ic_audio,"Line "+position,"This is Line "+position));
        madapter.notifyItemInserted(position);
    }


    private void creatingList() {
        itemExamples=new ArrayList<>();
        itemExamples.add(new ItemExample(R.drawable.ic_android,"Line 1","Line 2"));
        itemExamples.add(new ItemExample(R.drawable.ic_audio,"Line 3","Line 4"));
        itemExamples.add(new ItemExample(R.drawable.ic_beach_access,"Line 5","Line 6"));

    }
    private void createRecyleView() {

        mrecycleview=findViewById(R.id.recyclerView);
        mrecycleview.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        madapter=new ExampleAdapter(itemExamples);

        mrecycleview.setLayoutManager(mlayoutManager);
        mrecycleview.setAdapter(madapter);


    }



}
