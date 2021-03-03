package edu.udb.recyclerviewdinamico;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;


public class TeamItemAdapter extends RecyclerView.Adapter<TeamItemAdapter.TeamViewHolder> {

    ArrayList<Team> teams = new ArrayList<>();
    Context context;

    public TeamItemAdapter(ArrayList<Team> teams, Context context){
        this.teams = teams;
        this.context = context;
    }

    @Override
    public TeamViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new TeamViewHolder(row);
    }

    @Override
    public void onBindViewHolder(TeamViewHolder holder, final int position) {
        Team team = teams.get(position);
        //Picasso.with(context).load(team.getImgLogo()).fit().placeholder(R.drawable.loading).error(R.drawable.alert).into(holder.imageLogo);
        Picasso.get().load(team.getImgLogo()).into(holder.imageLogo);
        holder.teamDescription.setText(team.getDescription());
        holder.teamName.setText(team.getTeamName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("teamdetail",teams.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return teams.size();
    }

    public static class TeamViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageLogo;
        private TextView teamName;
        private TextView teamDescription;

        public TeamViewHolder(View itemView) {
            super(itemView);
            imageLogo = (ImageView) itemView.findViewById(R.id.teamImage);
            teamName = (TextView) itemView.findViewById(R.id.teamName);
            teamDescription = (TextView) itemView.findViewById(R.id.teamDescription);

        }

        public ImageView getImageLogo() {
            return imageLogo;
        }

        public void setImageLogo(ImageView imageLogo) {
            this.imageLogo = imageLogo;
        }

        public TextView getTeamName() {
            return teamName;
        }

        public void setTeamName(TextView teamName) {
            this.teamName = teamName;
        }

        public TextView getTeamDescription() {
            return teamDescription;
        }

        public void setTeamDescription(TextView teamDescription) {
            this.teamDescription = teamDescription;
        }
    }

}
