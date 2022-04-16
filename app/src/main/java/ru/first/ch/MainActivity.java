package ru.first.ch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button)findViewById(R.id.activity_main__button2);
        button1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.activity_main__button2:
                Intent intent = new Intent(this, WeekComActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}