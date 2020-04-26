package au.edu.unsw;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class StudyFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tvA1;
    private TextView tv_a2;
    private TextView tv_a3;
    private TextView tv_b1;
    private TextView tv_b2;
    private TextView tv_b3;
    private TextView tv_c1;
    private TextView tv_c2;
    private TextView tv_c3;
    //create the view of Study page
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        view =  inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
            tvA1 = view.findViewById(R.id.tv_a1);
            tv_a2 = view.findViewById(R.id.tv_a2);
            tv_a3 = view.findViewById(R.id.tv_a3);
            tv_b1 = view.findViewById(R.id.tv_b1);
            tv_b2 = view.findViewById(R.id.tv_b2);
            tv_b3 = view.findViewById(R.id.tv_b3);
            tv_c1 = view.findViewById(R.id.tv_c1);
            tv_c2 = view.findViewById(R.id.tv_c2);
            tv_c3 = view.findViewById(R.id.tv_c3);
       view.findViewById(R.id.tv_cloud).setOnClickListener(new View.OnClickListener() {
           @Override
           // set onclicklistener on every tpoic
           public void onClick(View view) {
               startActivity(new Intent(getActivity(),MusicActivity.class));
           }
       });
        tvA1.setOnClickListener(this);
        tv_a2.setOnClickListener(this);
        tv_a3.setOnClickListener(this);
        tv_b1.setOnClickListener(this);
        tv_b2.setOnClickListener(this);
        tv_b3.setOnClickListener(this);
        tv_c1.setOnClickListener(this);
        tv_c2.setOnClickListener(this);
        tv_c3.setOnClickListener(this);

    }
    //match every topic
    @Override
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
        if (introduction1==1){
            tvA1.setSelected(true);
        }
        if (introduction2==1){
            tv_a2.setSelected(true);
        }
        if (introduction3==1){
            tv_a3.setSelected(true);
        }
        if (intermediate1==1){
            tv_b1.setSelected(true);
        }
        if (intermediate2==1){
            tv_b2.setSelected(true);
        }
        if (intermediate3==1){
            tv_b3.setSelected(true);
        }
        if (expert1==1){
            tv_c1.setSelected(true);
        }
        if (expert2==1){
            tv_c2.setSelected(true);
        }
        if (expert3==1){
            tv_c3.setSelected(true);
        }
    }
    // click buttons to nevigate to different topics
    @Override
    public void onClick(View view) {
        Intent intent ;
        switch (view.getId()){
            case R.id.tv_a1:
                intent = new Intent(getActivity(),IntroductionDesActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_a2:
                intent = new Intent(getActivity(),IntroductionDes2Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_a3:
                intent = new Intent(getActivity(),IntroductionDes3Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_b1:
                intent = new Intent(getActivity(),IntermediateDesActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_b2:
                intent = new Intent(getActivity(),IntermediateDes2Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_b3:
                intent = new Intent(getActivity(),IntermediateDes3Activity.class);
                intent.putExtra("type","intermediate");
                intent.putExtra("number",3);
                startActivity(intent);
                break;
            case R.id.tv_c1:
                intent = new Intent(getActivity(),ExpertDesActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_c2:
                intent = new Intent(getActivity(),ExpertDes2Activity.class);
                startActivity(intent);
                break;
            case R.id.tv_c3:
                intent = new Intent(getActivity(),ExpertDes3Activity.class);
                startActivity(intent);
                break;
        }
    }
}
