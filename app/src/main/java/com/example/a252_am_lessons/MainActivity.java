package com.example.a252_am_lessons;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.i("testing", String.valueOf(R.string.log_message));
        //1 encontrar container
        LinearLayout container = findViewById(R.id.container);

        //2 crear el text view
        TextView textView = new TextView(this);
        textView.setText(R.string.welcome_message);

        //3 crear el button
        Button button = new Button(this);
        button.setBackgroundColor(R.color.violet);
        button.setText(R.string.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                button.setText("le hice click");
                textView.setText("le hice click también");
            }
        });

        Button button2 = new Button(this);
        button2.setBackgroundColor(R.color.black);
        button2.setText(R.string.button);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                button.setText("le hice click");
                textView.setText("le hice desde otro lado");
            }
        });

        //4 agregar los hijos al container
        container.addView(textView);
        container.addView(button);
        container.addView(button2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}