package au.edu.unsw;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IntroductionDes2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction2);

        final MediaPlayer canonA = MediaPlayer.create(this, R.raw.canoninda);
        final MediaPlayer canonB = MediaPlayer.create(this, R.raw.canonindb);
        final MediaPlayer canonC = MediaPlayer.create(this, R.raw.canonindc);

    // sound folders to play when clicked
    findViewById(R.id.soundA).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canonA.start();

            }
        });
        findViewById(R.id.soundB).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canonB.start();

            }
        });
        findViewById(R.id.soundC).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canonC.start();

            }
        });

        findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
        @Override
        // go to the exam activity with the correct question of the topic
        public void onClick(View view) {
            Intent intent = new Intent(IntroductionDes2Activity.this, ExamActivity.class);
            intent.putExtra("type","introduction");
            intent.putExtra("number",2);
            startActivity(intent);
            finish();
        }
    });
        Toolbar toolbar =  findViewById(R.id.at_toolbar);
        if (toolbar==null){
            return;
        }
// navigate to the next question
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.nav_left);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
