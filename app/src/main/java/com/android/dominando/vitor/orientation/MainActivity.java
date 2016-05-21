package com.android.dominando.vitor.orientation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText mEditText;
    ArrayList<String> mNames;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mNames = savedInstanceState.getStringArrayList("names");
        } else {
            mNames = new ArrayList<>();
        }
        mEditText = (EditText) findViewById(R.id.myEditText);

        ListView listView = (ListView) findViewById(R.id.myListView);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mNames);
        listView.setAdapter(mAdapter);
    }

    public void myButtonClick(View v) {
        mNames.add(mEditText.getText().toString());
        mEditText.setText("");
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("names", mNames);
    }
}
