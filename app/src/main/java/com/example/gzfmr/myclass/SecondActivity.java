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
    public static final String MACTION = "android.intent.action.simple.THIRDACTIVITY";
    private Button btnBack;
    private Button btnThird;

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

        btnThird = (Button) findViewById(R.id.btn_Third);
        btnThird.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.btn_Third:

                intent = new Intent();
                intent.putExtra(TAG, "i am comming third activity");
                intent.setAction(MACTION);
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
                this.finish();

                break;
            case R.id.btn_back:

                intent = new Intent();

                intent.putExtra(TAG, "I'm back");

                ComponentName cn = new ComponentName(this, MainActivity.class);

//                intent.setClass(this, MainActivity.class);
                intent.setComponent(cn);

                startActivity(intent);

                this.finish();

                break;
        }

    }
}
