package com.example.gzfmr.myclass;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String TAG = "MainActivity";
    private Button btnJump;
    //此行注释是为了测试GitHub的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent mIntent = this.getIntent();

        Toast.makeText(this, mIntent.getStringExtra(SecondActivity.TAG), Toast.LENGTH_SHORT).show();

        initButton();
    }

    private void initButton() {
        btnJump = (Button) findViewById(R.id.btn_jump);
        btnJump.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_jump:

//                Intent intent = new Intent(this, SecondActivity.class);
                Intent intent = null;
                intent = new Intent();

                intent.putExtra(TAG, "I am going");

                ComponentName cn = new ComponentName(this, SecondActivity.class);
                intent.setComponent(cn);

                startActivity(intent);

                this.finish();

                break;
        }

    }
}
