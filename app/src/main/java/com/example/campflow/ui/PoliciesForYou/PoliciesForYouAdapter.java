package com.example.campflow.ui.PoliciesForYou;

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

public class PoliciesForYouAdapter  extends RecyclerView.Adapter<PoliciesForYouAdapter.PolicyViewHolder>{

    private Context context;
    private ArrayList<PoliciesForYouClass> mPolicies;

    public PoliciesForYouAdapter(Context context){
        this.context=context;
    }

    public PoliciesForYouAdapter(Context context,ArrayList<PoliciesForYouClass> Policiees) {
        this.context=context;
        this.mPolicies=Policiees;
    }

    @NonNull
    @Override
    public PolicyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this controls how the current view will work in background.
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.card_policies_for_you, parent, false);

        final TextView PolicyHead=(TextView)view.findViewById(R.id.policy_head);
        final TextView PolicyDescription=(TextView)view.findViewById(R.id.policy_description);
        final ImageView PolicyImage=(ImageView)view.findViewById(R.id.policy_image);
        final TextView PolicyWeb=(TextView)view.findViewById(R.id.policy_web);

        return (new PolicyViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull PolicyViewHolder holder, int position) {
        if (mPolicies != null) {
         //   PoliciesForYouClass currentPolicy = mPolicies.get(position);
            PoliciesForYouClass currentPolicy= mPolicies.get(position);
                holder.policy_id.setText(currentPolicy.getPolicy_id());
                holder.policy_head.setText(currentPolicy.getPolicy_head());
                holder.policy_description.setText(currentPolicy.getPolicy_description());
                Glide.with(context)
                        .load(currentPolicy.getPolicy_image())
                        .thumbnail(Glide.with(context).load(R.drawable.ic_launcher_foreground))
                        .into(holder.policy_image);
                holder.policy_web.setText(currentPolicy.getPolicy_web());
        }
    }

    @Override
    public int getItemCount() {
        if(mPolicies!=null)
            return mPolicies.size();
        else
            return  0;
    }

    public class PolicyViewHolder extends RecyclerView.ViewHolder {

        public TextView policy_id;
        public TextView policy_head;
        public TextView policy_description;
        public ImageView policy_image;
        public TextView policy_web;

        public PolicyViewHolder(@NonNull View itemView) {
            super(itemView);
            policy_id=(TextView)itemView.findViewById(R.id.policy_id);
            policy_head=(TextView)itemView.findViewById(R.id.policy_head);
            policy_description=(TextView)itemView.findViewById(R.id.policy_description);
            policy_image=(ImageView)itemView.findViewById(R.id.policy_image);
            policy_web=(TextView)itemView.findViewById(R.id.policy_web);

        }
    }
}
