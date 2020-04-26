package au.edu.unsw;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    private EditText etFirst;
    private EditText etLast;
    private EditText etEmail;
    //create view for user registration
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        etFirst = findViewById(R.id.et_first);
        etLast =  findViewById(R.id.et_last);
        etEmail = findViewById(R.id.et_email);
       findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
           @Override
           // click to enter the detail
           public void onClick(View view) {
               String firstName = etFirst.getText().toString();
               String lastName = etLast.getText().toString();
               String email = etEmail.getText().toString();
               if (TextUtils.isEmpty(firstName)){
                   return;
               } if (TextUtils.isEmpty(lastName)){
                   return;
               } if (TextUtils.isEmpty(email)){
                   return;
               }

               SharedPreferences sp = getSharedPreferences("music", MODE_PRIVATE);
               SharedPreferences.Editor edit = sp.edit();
               edit.putString("firstName",firstName);
               edit.putString("lastName",lastName);
               edit.putString("email",email);
               edit.commit();
               startActivity(new Intent(RegisterActivity.this,MainActivity.class));
               finish();
           }
       });
    }
}
