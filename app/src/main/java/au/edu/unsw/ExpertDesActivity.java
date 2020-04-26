package au.edu.unsw;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ExpertDesActivity extends AppCompatActivity {
    @Override
    //create the expert 1 view
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert);


    findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
        @Override
        // go to the exam activity with the correct question of the topic
        public void onClick(View view) {
            Intent intent = new Intent(ExpertDesActivity.this, ExamActivity.class);
            intent.putExtra("type","expert");
            intent.putExtra("number",1);
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
