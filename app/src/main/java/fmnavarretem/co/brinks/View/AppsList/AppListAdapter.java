package fmnavarretem.co.brinks.View.AppsList;

import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import fmnavarretem.co.brinks.Model.POJO.App;
import fmnavarretem.co.brinks.R;

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.AppListAdapterViewHolder> {

    private List<App> apps;
    private IAppListAdapter listener;

    public AppListAdapter(List<App> apps, IAppListAdapter listener) {
        this.apps = apps;
        this.listener = listener;
    }

    public void setApps(List<App> apps) {
        this.apps = apps;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AppListAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_app,parent,false);
        return new AppListAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AppListAdapterViewHolder holder, int position) {
        final App app = apps.get(position);
        holder.tvCardAppName.setText(app.getImName().getLabel());
        Picasso.get().load(app.getImImage().get(0).getLabel()).into(holder.ivCardApp);
        holder.containerCardApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCardClick(app);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    class AppListAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivCardApp;
        private TextView tvCardAppName;
        private ConstraintLayout containerCardApp;

        public AppListAdapterViewHolder(View itemView) {
            super(itemView);
            ivCardApp = (ImageView) itemView.findViewById(R.id.iv_card_app);
            tvCardAppName = (TextView) itemView.findViewById(R.id.tv_card_app_name);
            containerCardApp = (ConstraintLayout) itemView.findViewById(R.id.container_card_app);
        }
    }
}
