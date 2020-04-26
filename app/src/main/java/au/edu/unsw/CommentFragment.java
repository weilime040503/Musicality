package au.edu.unsw;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CommentFragment extends Fragment {
    private View view;
    private RecyclerView recyclerview;
    private CommentAdapter adapter;
    private List<Comment> list = new ArrayList<>();

    @Nullable
    @Override
    // create the fragment to contain list  of comment
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view =  inflater.inflate(R.layout.fragment_comment,container,false);
        return view;
    }

    @Override
    // add comment item into the list
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new CommentAdapter(getActivity(),list);
        recyclerview.setAdapter(adapter);
        TextView tv_add = view.findViewById(R.id.tv_add);
        tv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),AddCommentActivity.class));

            }
        });
        adapter.setOnItemClickListener(new CommentAdapter.ItemClickListener() {
            @Override
            public void setOnItemClickListener(int position) {

            }

            @Override
            // the action if to delete the comment
            public void setOnItemLongClickListener(final int position) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Alert")
                        .setMessage("Do you want to delete?")
                        .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                CommentDao.getInstance(getActivity()).del(list.get(position).getId()+"");
                                list.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        }).setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
            }
        });
    }
    // have data store in sqlite
    @Override
    public void onResume() {
        super.onResume();
        List<Comment> commentList = CommentDao.getInstance(getActivity()).loadComment();
        list.clear();
        list.addAll(commentList);
        adapter.notifyDataSetChanged();
    }
}
