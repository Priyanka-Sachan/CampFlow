package com.example.campflow.ui.EventsNearMe;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.campflow.R;

import java.util.ArrayList;

public class EventsNearMeAdapter  extends RecyclerView.Adapter<EventsNearMeAdapter.EventViewHolder>{

    private Context context;
    private ArrayList<EventsNearMeClass> mEvents;

    public EventsNearMeAdapter(Context context){
        this.context=context;
    }

    public EventsNearMeAdapter(Context context,ArrayList<EventsNearMeClass> Events) {
        this.context=context;
        this.mEvents=Events;
    }

    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //this controls how the current view will work in background.
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.card_events_near_me, parent, false);

        final TextView EventHead=(TextView)view.findViewById(R.id.event_head);
        final TextView EventLocation=(TextView)view.findViewById(R.id.event_location);
        final TextView EventDescription=(TextView)view.findViewById(R.id.event_description);
        final ImageView EventImage=(ImageView)view.findViewById(R.id.event_image);
        final TextView EventWeb=(TextView) view.findViewById(R.id.event_web);
        ImageButton EventShare=(ImageButton) view.findViewById(R.id.event_share);
        final TextView EventInterested=(TextView)view.findViewById(R.id.event_interested);

        //Problems with opening browser.Will see to it later:-|
        EventWeb.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        String url=(String) EventWeb.getText();
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse(url));
                        context.startActivity(intent);
                    }
                }
        );

        EventShare.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,EventHead.getText()+
                        "\n\nLocation:"+EventLocation.getText()+"\n\n"
                        +EventDescription.getText()
                        +"\n\n"+EventInterested.getText()+" are interested!!!Are U??"
                        +"\n\nFor more information,visit us at: "+EventWeb.getText());
                intent.setType("text/plain");
                context.startActivity(intent);
            }
        });

        return (new EventViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        if (mEvents != null) {
            EventsNearMeClass currentEvent = mEvents.get(position);
                holder.event_id.setText("#"+currentEvent.getEvent_id());
                holder.event_head.setText(currentEvent.getEvent_head());
                holder.event_location.setText(currentEvent.getEvent_location());
                holder.event_description.setText(currentEvent.getEvent_description());
                Glide.with(context)
                        .load(currentEvent.getEvent_image())
                        .thumbnail(Glide.with(context).load(R.drawable.ic_launcher_foreground))
                        .into(holder.event_image);
                holder.event_web.setText("Visit us at: "+currentEvent.getEvent_web());
                holder.event_interested.setText(currentEvent.getEvent_interested()+" are interested!!!");
        }
    }

    @Override
    public int getItemCount() {
        if(mEvents!=null)
            return mEvents.size();
        else
            return  0;
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {

        public TextView event_id;
        public TextView event_head;
        public TextView event_location;
        public TextView event_description;
        public ImageView event_image;
        public TextView event_web;
        public TextView event_interested;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            event_id=(TextView)itemView.findViewById(R.id.event_id);
            event_head=(TextView)itemView.findViewById(R.id.event_head);
            event_location=(TextView)itemView.findViewById(R.id.event_location);
            event_description=(TextView)itemView.findViewById(R.id.event_description);
            event_image=(ImageView)itemView.findViewById(R.id.event_image);
            event_web=(TextView)itemView.findViewById(R.id.event_web);
            event_interested=(TextView)itemView.findViewById(R.id.event_interested);

        }
    }
}
