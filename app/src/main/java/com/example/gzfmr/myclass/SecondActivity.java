package com.example.gzfmr.myclass;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "SecondActivity";
    private Button btnBack;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent mIntent = this.getIntent();

        Toast.makeText(this, mIntent.getStringExtra(MainActivity.TAG), Toast.LENGTH_SHORT).show();

        initButton();
    }

    private void initButton() {
        btnBack= (Button) findViewById(R.id.btn_back);
        btnBack.setOnClickListener(this);

        btnStart= (Button) findViewById(R.id.btn_start);
        btnStart.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent = null;
        intent = new Intent();
        ComponentName cn = null;

        switch (view.getId()) {
            case R.id.btn_start:

                cn = new ComponentName(this, SecondActivity.class);

                intent.setComponent(cn);

                startActivity(intent);


                break;
            case R.id.btn_back:


                intent.putExtra(TAG, "I'm back");

                cn = new ComponentName(this, MainActivity.class);

//                intent.setClass(this, MainActivity.class);
                intent.setComponent(cn);

                startActivity(intent);

                this.finish();

                break;
        }

    }
}
