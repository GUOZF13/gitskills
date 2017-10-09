package com.example.gzfmr.myclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "SecondActivity";
    private Button btnBack;

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

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_back:

                Intent intent = null;
                intent = new Intent();

                intent.putExtra(TAG, "I'm back");

                intent.setClass(this, MainActivity.class);

                startActivity(intent);

                this.finish();

                break;
        }

    }
}
