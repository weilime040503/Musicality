package au.edu.unsw;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class IntermediateDes3Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inter3);


    findViewById(R.id.bt_start).setOnClickListener(new View.OnClickListener() {
        // go to the exam activity with the correct question of the topic
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(IntermediateDes3Activity.this, ExamActivity.class);
            intent.putExtra("type","intermediate");
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
