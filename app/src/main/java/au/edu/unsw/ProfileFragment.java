package au.edu.unsw;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    private View view;
    private SharedPreferences sp;
    private LinearLayout ll_introduction;
    private LinearLayout ll_intermediate;
    private LinearLayout ll_expert;
    private ProgressBar progress;
    private ProgressBar progress1, progress2, progress3;
    private TextView progress1text, progress2text, progress3text;

    //https://api.mixcloud.com/search/?q=coding+podcast&amp;type=cloudcast
    //create view for profile page
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view =  inflater.inflate(R.layout.fragment_profile,container,false);
        return view;
    }

    @Override
    //match the user detail,the progress and the level on profile page
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView userName = view.findViewById(R.id.user_name);
        TextView userEmail = view.findViewById(R.id.user_mail);
    // get the information which stored in shared prefferences
        sp = getActivity(). getSharedPreferences("music", Context.MODE_PRIVATE);
        String firstName = sp.getString("firstName", "");
        String lastName = sp.getString("lastName", "");
        String email = sp.getString("email", "");
        userEmail.setText(email);
        userName.setText(firstName+","+lastName);

        view.findViewById(R.id.ll_introduction);
        view.findViewById(R.id.ll_intermediate);
        progress = view.findViewById(R.id.progress);
        progress1 = view.findViewById(R.id.progress1);
        progress2 = view.findViewById(R.id.progress2);
        progress3 = view.findViewById(R.id.progress3);
        progress1text = view.findViewById(R.id.badge1progress);
        progress2text = view.findViewById(R.id.badge2progress);
        progress3text = view.findViewById(R.id.badge3progress);
        ll_introduction = view.findViewById(R.id.ll_introduction);
        ll_intermediate = view.findViewById(R.id.ll_intermediate);
        ll_expert = view.findViewById(R.id.ll_expert);
    }

    @Override
    //check if each level- intro,inter and expert accesses
    public void onResume() {
        super.onResume();
        SharedPreferences musicSP = getActivity().getSharedPreferences("MUSIC", Context.MODE_PRIVATE);
        int introduction1 =  musicSP.getInt("introduction1",0);
        int introduction2 =  musicSP.getInt("introduction2",0);
        int introduction3 =  musicSP.getInt("introduction3",0);
        int intermediate1 =  musicSP.getInt("intermediate1",0);
        int intermediate2 =  musicSP.getInt("intermediate2",0);
        int intermediate3 =  musicSP.getInt("intermediate3",0);
        int expert1 =  musicSP.getInt("expert1",0);
        int expert2 =  musicSP.getInt("expert2",0);
        int expert3 =  musicSP.getInt("expert3",0);
        if (introduction1+introduction2+introduction3==3){
            ll_introduction.setSelected(true);
        }

        if (intermediate1+intermediate2+intermediate3==3){
            ll_intermediate.setSelected(true);
        }

        if (expert1+expert2+expert3==3){
            ll_expert.setSelected(true);
        }
        //sets progress bar to match how many topics completed
        progress1text.setText(introduction1+introduction2+introduction3 + "/3");
        progress2text.setText(intermediate1+intermediate2+intermediate3 + "/3");
        progress3text.setText(expert1+expert2+expert3 + "/3");
        progress1.setProgress(introduction1+introduction2+introduction3);
        progress2.setProgress((intermediate1+intermediate2+intermediate3));
        progress3.setProgress(expert1+expert2+expert3);
        progress.setProgress(introduction1+introduction2+introduction3+intermediate1+intermediate2+intermediate3+expert1+expert2+expert3);
    }
}
