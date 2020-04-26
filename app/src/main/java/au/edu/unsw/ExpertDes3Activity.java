package au.edu.unsw;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ExpertDes3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert3);


        int res1 = getResources().getIdentifier("menuett2", "raw", "au.edu.unsw");

        final MediaPlayer menuett2 = MediaPlayer.create(this, res1);

        // sound folders to play when clicked
        findViewById(R.id.menuett2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuett2.start();

            }
        });

    findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
        // go to the exam activity with the correct question of the topic
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(ExpertDes3Activity.this, ExamActivity.class);
            intent.putExtra("type","expert");
            intent.putExtra("number",3);
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
