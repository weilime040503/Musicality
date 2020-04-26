package au.edu.unsw;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private StudyFragment mStudyFragment;
    private CommentFragment mCommentFragment;
    private ProfileFragment mProfileFragment;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // create the view that is able to switch between the study, comment and profile page
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStudyFragment = new StudyFragment();
        mCommentFragment = new CommentFragment();
        mProfileFragment = new ProfileFragment();

        bottomNavigationView = findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.navigation_home) {
                    switchTab(mStudyFragment);
                    return true;
                } else if (menuItem.getItemId() == R.id.navigation_dashboard) {
                    switchTab(mCommentFragment);
                    return true;
                }else if (menuItem.getItemId() == R.id.navigation_notifications) {
                    switchTab(mProfileFragment);
                    return true;
                }
                return false;
            }
        });
        switchTab(mStudyFragment);
    }
    // create a method that switches the fragment for the selected one
    private void switchTab(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_slot, fragment);
        fragmentTransaction.commit();
    }
}
