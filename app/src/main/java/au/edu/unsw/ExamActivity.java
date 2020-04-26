package au.edu.unsw;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class ExamActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvQuesion;
    private Topic mTopic;
    private List<Question> exams;
    private int position=0;
    private TextView tvA;
    private TextView tvB;
    private ImageView ivImg;
    private Question data;
    private int correct;
    private int number;
    private String type;
    private String answer;
    private TextView progresstv;
    private ProgressBar progress;


    //create view for typing the answer
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        Toolbar toolbar =  findViewById(R.id.toolbar);
        if (toolbar==null){
            return;
        }
// navigate to the next question

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationIcon(R.drawable.nav_left);
        toolbar.setNavigationOnClickListener(v -> finish());


        // declaring the normal stuff and getting intents based from the previous activity


        progresstv = findViewById(R.id.progresstv);
        ivImg = findViewById(R.id.iv_img);
        progress = findViewById(R.id.progress);
        tvQuesion = findViewById(R.id.tv_title);
        Button BtnA = findViewById(R.id.AnswerA);
        Button BtnB = findViewById(R.id.AnswerB);
        Button btNext = findViewById(R.id.bt_next);
        tvA = findViewById(R.id.tv_a);
        tvB = findViewById(R.id.tv_b);
         type = getIntent().getStringExtra("type");
         number = getIntent().getIntExtra("number",1);
        mTopic = Topic.getList(type,number);
        exams = mTopic.mQuestions;
        init();
        tvA.setOnClickListener(this);
        tvB.setOnClickListener(this);
        btNext.setOnClickListener(this);
        ivImg.setOnClickListener(this);
        progress.setMax(exams.size());


    }


    private void show(){
        //pop up message showing if user gets all the answers right
        if (correct==exams.size()){
            new AlertDialog.Builder(this)
                    .setTitle("Congratulations: You got it all Right!!")
                    .setMessage(mTopic.end)
                    .setPositiveButton("Return", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            SharedPreferences musicSP = getSharedPreferences("MUSIC", MODE_PRIVATE);
                            SharedPreferences.Editor edit = musicSP.edit();
                            edit.putInt(type+number,1);
                            edit.commit();
                            finish();
                        }
                    }).create().show();
        }else{
            // lets user know how many they got correct and returns them back meaning not all questions correct
            new AlertDialog.Builder(this)
                    .setTitle("Try again!")
                    .setMessage("You got " +correct+" correct out of " + position)
                    .setPositiveButton("Return", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();

                        }
                    }).create().show();
        }

    }
    private void init() {
        // checker for when the whole question is finished for the topic as well as setting new icons for the next question when not finished
        if (position>=exams.size()){
            show();
            return;
        }

         data = exams.get(position);
        tvQuesion.setText(data.title);
        // checks if there is a 3rd element needed
        if (TextUtils.isEmpty(data.titleUrl)){
            ivImg.setVisibility(View.GONE);
            tvQuesion.setCompoundDrawables(null,null,null,null);
        }else{
            //if it doesnt contain an icon puts the image view of play button
            if (!data.titleUrl.contains("icon")){
                ivImg.setImageResource(R.drawable.play);
                ivImg.setVisibility(View.VISIBLE);
            }else{
                int titleUrl = getImageResource(data.titleUrl);
                ivImg.setImageResource(titleUrl);
                ivImg.setVisibility(View.VISIBLE);
            }

        }

        // determining the type of question that is either a Text, youtube Link or image
        if (data.ansType.equals("text")){
            tvA.setText("A."+data.a);
            tvB.setText("B."+data.b);

            tvA.setCompoundDrawables(null,null,null,null);
            tvB.setCompoundDrawables(null,null,null,null);
        }else if (data.ansType.equals("url")){
            Drawable drawable = getResources().getDrawable(R.drawable.play);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            tvA.setCompoundDrawables(null,null,drawable,null);
            tvB.setCompoundDrawables(null,null,drawable,null);

            tvA.setText("A.");
            tvB.setText("B.");
        }else if (data.ansType.equals("image")){
            int imageA = getImageResource(data.a);
            int imageB = getImageResource(data.b);
            tvA.setText("A.");
            tvB.setText("B.");
            Drawable drawableA = getResources().getDrawable(imageA);
            drawableA.setBounds(0, 0, drawableA.getMinimumWidth(), drawableA.getMinimumHeight());
            tvA.setCompoundDrawables(null,null,drawableA,null);
            Drawable drawableB= getResources().getDrawable(imageB);
            drawableB.setBounds(0, 0, drawableB.getMinimumWidth(), drawableB.getMinimumHeight());
            tvB.setCompoundDrawables(null,null,drawableB,null);
        }

    }

    public int  getImageResource(String imageName){
        Context ctx=getBaseContext();
        int resId = getResources().getIdentifier(imageName, "drawable", ctx.getPackageName());
        return resId;
    }
// when btn A is clicked sets the answer to a and shows the Next button
    public void setAnswerA(View view) {
        answer = "a";
        Button btNext = findViewById(R.id.bt_next);
        btNext.setVisibility(View.VISIBLE);

    }
    // when btn B is clicked sets the answer to b and shows the Next button
    public void setAnswerB(View view) {
        answer = "b";
        Button btNext = findViewById(R.id.bt_next);
        btNext.setVisibility(View.VISIBLE);
    }

    @Override
    // Checks how many is correct and stores them in int correct
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_next:
                // if wrong answer
                Button btNext = findViewById(R.id.bt_next);
                if (TextUtils.isEmpty(answer)){
                    return;
                }
                // if right answer increases counter
                if (answer.toLowerCase().equals(data.ok)){
                    correct++;
                }
                // when number of questions = exam size shows the results
                if (position>=exams.size()){
                    show();
                    return;
                }
                // always increases position or question value
                position++;
                btNext.setVisibility(View.INVISIBLE);
                progress.setProgress(position);

                init();
                break;
                //in the cases of url to display the correct data
            // instead plays the youtube video of the question required
            case R.id.tv_a:
                if (data.ansType.equals("url")){
                   goToYoutube(data.a);
                }
                break;
            case R.id.tv_b:
                if (data.ansType.equals("url")){
                    goToYoutube(data.b);

                }

                break;
                // checks what to set the iv_img to do depending if its music or its a youtube video
            case R.id.iv_img:
                if (!TextUtils.isEmpty(data.title)){
                    if(data.titleUrl.contains("music")) {
                        playMusic(data.titleUrl);
                    }
                    if (!data.titleUrl.contains("icon") && !data.titleUrl.contains("music")){
                        goToYoutube(data.titleUrl);
                    }

                }

                break;
        }
    }
// youtube intent feature
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
//method to play sounds if there is

    private void playMusic(String music){
        int res1 = getResources().getIdentifier(music, "raw", "au.edu.unsw");
        final MediaPlayer musicplayer = MediaPlayer.create(this, res1);
        musicplayer.start();

    }
}
