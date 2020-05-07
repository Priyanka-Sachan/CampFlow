package com.example.campflow.ui.Posts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.campflow.R;

import java.util.ArrayList;

public class PostsAdapter  extends RecyclerView.Adapter<PostsAdapter.PostViewHolder>{

    private Context context;
    private ArrayList<PostsClass> mPosts;

    public PostsAdapter(Context context){
        this.context=context;
    }

    public PostsAdapter(Context context,ArrayList<PostsClass> Posts) {
        this.context=context;
        this.mPosts=Posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this controls how the current view will work in background.
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_posts, parent, false);

        final TextView PostHead=(TextView)view.findViewById(R.id.post_head);
        final TextView PostAuthor=(TextView)view.findViewById(R.id.post_author);
        final TextView PostDescription=(TextView)view.findViewById(R.id.post_description);
        final ImageView PostImage=(ImageView)view.findViewById(R.id.post_image);
        final TextView PostWeb=(TextView)view.findViewById(R.id.post_web);

        return (new PostViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        if (mPosts != null) {
            PostsClass currentPost = mPosts.get(position);
            holder.post_id.setText(currentPost.getPost_id());
            holder.post_head.setText(currentPost.getPost_head());
            holder.post_author.setText(currentPost.getPost_author());
            holder.post_description.setText(currentPost.getPost_description());
            Glide.with(context)
                    .load(currentPost.getPost_image())
                    .thumbnail(Glide.with(context).load(R.drawable.ic_launcher_foreground))
                    .into(holder.post_image);
            holder.post_web.setText(currentPost.getPost_web());
        }
    }

    @Override
    public int getItemCount() {
        if(mPosts!=null)
            return mPosts.size();
        else
            return  0;
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        public TextView post_id;
        public TextView post_head;
        public TextView post_author;
        public TextView post_description;
        public ImageView post_image;
        public TextView post_web;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            post_id=(TextView)itemView.findViewById(R.id.post_id);
            post_head=(TextView)itemView.findViewById(R.id.post_head);
            post_author=(TextView)itemView.findViewById(R.id.post_author);
            post_description=(TextView)itemView.findViewById(R.id.post_description);
            post_image=(ImageView)itemView.findViewById(R.id.post_image);
            post_web=(TextView)itemView.findViewById(R.id.post_web);
        }
    }
}

