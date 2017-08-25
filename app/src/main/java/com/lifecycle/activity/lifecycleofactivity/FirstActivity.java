package com.lifecycle.activity.lifecycleofactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lifecycle.activity.lifecycleofactivity.utils.DeprecateCheck;

public class FirstActivity extends AppCompatActivity {

    String TAG = FirstActivity.class.getSimpleName();
    TextView onCreateTxt, onStartTxt, onRestartTxt, onResumeTxt, onPauseTxt, onStopTxt, onDestroyTxt;
    Context context;
    Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, TAG + " onCreate called", Toast.LENGTH_SHORT).show();
        context = FirstActivity.this;

        onCreateTxt = (TextView) findViewById(R.id.oncrete_txt);
        onStartTxt = (TextView) findViewById(R.id.onstart_txt);
        onRestartTxt = (TextView) findViewById(R.id.onrestart_txt);
        onResumeTxt = (TextView) findViewById(R.id.onresume_txt);
        onPauseTxt = (TextView) findViewById(R.id.onpause_txt);
        onStopTxt = (TextView) findViewById(R.id.onstop_txt);
        onDestroyTxt = (TextView) findViewById(R.id.ondestroy_txt);
        button = (Button) findViewById(R.id.button);
        button.setText("Move to Second Activity");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, SecondActivity.class);
                startActivity(i);
            }
        });

        called(onCreateTxt);
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(this, TAG + " onStart called", Toast.LENGTH_SHORT).show();

        called(onStartTxt);
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(this, TAG + " onRestart called", Toast.LENGTH_SHORT).show();

        called(onRestartTxt);
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(this, TAG + " onResume called", Toast.LENGTH_SHORT).show();

        called(onResumeTxt);
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(this, TAG + " onPause called", Toast.LENGTH_SHORT).show();

        called(onPauseTxt);
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(this, TAG + " onStop called", Toast.LENGTH_SHORT).show();

        called(onStopTxt);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, TAG + " onDestroy called", Toast.LENGTH_SHORT).show();

        called(onDestroyTxt);
    }

    void called(TextView textView) {
        textView.setTextColor(DeprecateCheck.getColor(R.color.green, context));
    }

}
