package com.example.runtry;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class ActivityR1C1 extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r1_c1);
        imageView = findViewById(R.id.pop_img);
        textView = findViewById(R.id.caption);

        Intent intent = getIntent();

        imageView.setImageResource(intent.getIntExtra("image",0));
        String info = getIntent().getStringExtra("title");
//        textView.setText(intent.getStringExtra("title"));

        if(Objects.equals(info, "0")) {
            textView.setText("Ready for some Hangman?");
        } else {
            textView.setText("Nothing to see here.");
        }

        FloatingActionButton play = findViewById(R.id.play_fab);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Objects.equals(info, "0")) {
                    Intent i = new Intent(ActivityR1C1.this, Hangman.class);
                    startActivity(i);
                    finish();
                } else {
                    Toast.makeText(ActivityR1C1.this, "Under Maintenance", Toast.LENGTH_SHORT).show();
                }


            }
        });

/*
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);
        if(getIntent() != null)
        {
            String info = getIntent().getStringExtra("info");
            txtInfo.setText(info);
        }

 */
    }
}