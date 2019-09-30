package com.djac21.haystax.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.djac21.haystax.R;
import com.djac21.haystax.Utils.Utils;
import com.djac21.haystax.activities.IncidentDetailActivity;
import com.djac21.haystax.model.IncidentsListModel;

import java.util.List;

public class IncidentListAdapter extends RecyclerView.Adapter<IncidentListAdapter.MyViewHolder> {

    private List<IncidentsListModel.Incidents> data;
    private Context context;

    public IncidentListAdapter(Context context, List<IncidentsListModel.Incidents> data) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.incidents_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        IncidentsListModel.Incidents incidentsListModel = data.get(position);
        holder.incidentTitle.setText(incidentsListModel.getTitle());
        holder.incidentDate.setText(Utils.prettyTime(incidentsListModel.getOverview().getDate()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView incidentTitle, incidentDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            incidentTitle = itemView.findViewById(R.id.incident_title);
            incidentDate = itemView.findViewById(R.id.incident_date);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            IncidentsListModel.Incidents incidentsListModel = data.get(getAdapterPosition());
            Intent intent = new Intent(context, IncidentDetailActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("ID", incidentsListModel.getId());
            context.startActivity(intent);
        }
    }
}