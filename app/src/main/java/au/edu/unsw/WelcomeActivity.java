package au.edu.unsw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.File;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {


    private TextView tvCreate;
    private SharedPreferences sp;

    @Override
    //create the page of create profile
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_welcome);

        sp = getSharedPreferences("music",MODE_PRIVATE);
        String firstName = sp.getString("firstName", "");
        if (!TextUtils.isEmpty(firstName)){
            startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            finish();
        }
        tvCreate = findViewById(R.id.tv_crete);
        tvCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            //click the button to create a profile
            public void onClick(View view) {
                startActivity(new Intent(WelcomeActivity.this,RegisterActivity.class));
                finish();
            }
        });
    }

}
