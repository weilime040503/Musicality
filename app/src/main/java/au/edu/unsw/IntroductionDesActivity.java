package au.edu.unsw;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IntroductionDesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);


    findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IntroductionDesActivity.this, ExamActivity.class);
            intent.putExtra("type","introduction");
            intent.putExtra("number",1);
            startActivity(intent);
            finish();
        }
    });
        Toolbar toolbar =  findViewById(R.id.at_toolbar);
        if (toolbar==null){
            return;
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.nav_left);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
    private void goToYoutube(String id){
        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + id));
        try {
            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
