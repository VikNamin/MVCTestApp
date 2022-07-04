package ru.vik.mvctestapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity implements Observer, View.OnClickListener {

    private Model myModel;

    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myModel = new Model();
        myModel.addObserver(this);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                myModel.setValueAtIndex(0);
                break;
            case R.id.button2:
                myModel.setValueAtIndex(1);
                break;
            case R.id.button3:
                myModel.setValueAtIndex(2);
                break;
        }
    }

    @Override
    public void update(Observable observable, Object o) {
        button1.setText("Count: " + myModel.getValueAtIndex(0));
        button2.setText("Count: " + myModel.getValueAtIndex(1));
        button3.setText("Count: " + myModel.getValueAtIndex(2));
    }
}