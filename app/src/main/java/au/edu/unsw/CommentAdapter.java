package au.edu.unsw;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;


public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {
    private Context context;
    private List<Comment> mComments;
    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.mComments = comments;
    }

    @NonNull
    @Override
    //create each item in the list of comments
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_comment, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Comment comment = mComments.get(position);

        holder.mtvTime.setText("Time:"+ comment.getTime());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            // create the listener to click if the comments exist
            public void onClick(View view) {
                if (listener!=null){
                    listener.setOnItemClickListener(position);
                }
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (listener!=null){
                    listener.setOnItemLongClickListener(position);
                }
                return false;
            }
        });
        holder.mTvName.setText(comment.getContent());
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTvName;
        TextView mtvTime;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.mTvName);
            mtvTime = itemView.findViewById(R.id.mtvTime);
        }
    }
    private ItemClickListener listener;
    public void setOnItemClickListener(ItemClickListener listener ){
        this.listener = listener;
    }
    public interface ItemClickListener{
        void setOnItemClickListener(int position);
        void setOnItemLongClickListener(int position);
    }
}
