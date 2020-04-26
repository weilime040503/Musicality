package au.edu.unsw;


import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AddCommentActivity extends AppCompatActivity {
    EditText mEtContent;
    TextView mBtAdd;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        initView();

    }
// Get time method
    private String getTime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    // displays the view in oncreate
    private void initView() {
        Toolbar toolbar =  findViewById(R.id.at_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.back_arr);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               finish();
            }
        });
        mEtContent = findViewById(R.id.et_content);
        mBtAdd = findViewById(R.id.bt_add);
        mBtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = mEtContent.getText().toString();
                String time = getTime(new Date());
                if (TextUtils.isEmpty(content)){
                    return;
                }
                CommentDao.getInstance(AddCommentActivity.this).addComment(new Comment(content,time));
                finish();
            }
        });
    }




}
