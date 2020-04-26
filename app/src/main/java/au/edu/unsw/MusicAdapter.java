package au.edu.unsw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    private Context context;
    private List<Cloud> mComments;
    public MusicAdapter(Context context, List<Cloud> comments) {
        this.context = context;
        this.mComments = comments;
    }

    @NonNull
    @Override
    //create the view to present the list of avaliable music in api
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_music, parent,false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Cloud cloud = mComments.get(position);
        // initialte the listener to navigate to the music
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener!=null){
                    listener.setOnItemClickListener(position);
                }
            }
        });

        holder.mTvName.setText(cloud.getName());
        holder.tv_user.setText(cloud.getUser().getName());
        holder.tv_des.setText(cloud.getCreated_time());
        Glide.with(context).load(cloud.getPictures().getThumbnail()).into(holder.iv_pic);
    }

    @Override
    public int getItemCount() {
        return mComments.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_pic;
        TextView mTvName;
        TextView tv_user;
        TextView tv_des;
        public ViewHolder(View itemView) {
            super(itemView);
            iv_pic = itemView.findViewById(R.id.iv_pic);
            mTvName = itemView.findViewById(R.id.tv_name);
            tv_user = itemView.findViewById(R.id.tv_user);
            tv_des = itemView.findViewById(R.id.tv_des);
        }
    }
    private ItemClickListener listener;
    public void setOnItemClickListener(ItemClickListener listener ){
        this.listener = listener;
    }
    public interface ItemClickListener{
        void setOnItemClickListener(int position);
    }
}
