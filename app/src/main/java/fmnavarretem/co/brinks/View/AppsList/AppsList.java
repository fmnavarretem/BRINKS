package fmnavarretem.co.brinks.View.AppsList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import fmnavarretem.co.brinks.Model.POJO.App;
import fmnavarretem.co.brinks.Presenter.AppsList.AppsListPresenter;
import fmnavarretem.co.brinks.Presenter.AppsList.IAppsListPresenter;
import fmnavarretem.co.brinks.R;
import fmnavarretem.co.brinks.Util.Constants;
import fmnavarretem.co.brinks.Util.JSONHelper;
import fmnavarretem.co.brinks.View.AppDetail.AppDetail;

public class AppsList extends AppCompatActivity implements IAppsListView, IAppListAdapter{

    private IAppsListPresenter presenter;
    private List<App> apps;

    private RecyclerView recycler;
    private ProgressBar progressBar;
    private AppListAdapter appListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_list);
        presenter = new AppsListPresenter(this);
        presenter.getApps();
        recycler = (RecyclerView) findViewById(R.id.rv_apps_list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(llm);
        progressBar = (ProgressBar) findViewById(R.id.prg_apps_list);
        (findViewById(R.id.bt_sort_alphabetically)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSortAlphabeticallyClick();
            }
        });
        (findViewById(R.id.bt_sort_date_release)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSortDateClick();
            }
        });
    }

    private void startAppsAdapter(List<App> apps){
        appListAdapter = new AppListAdapter(apps,this);
        recycler.setAdapter(appListAdapter);
    }

//    MARK: Actions
    private void onSortAlphabeticallyClick(){
        presenter.doSortAlphebetical(apps);
    }

    private void onSortDateClick(){
        presenter.doSortDate(apps);
    }

//    MARK: IAppsListView
    @Override
    public void notifyReceivedApps(List<App> apps) {
        progressBar.setVisibility(View.GONE);
        this.apps = apps;
        startAppsAdapter(apps);
    }

    @Override
    public void notifyAlphabeticallySorted(List<App> apps) {
        this.apps = apps;
        appListAdapter.setApps(apps);
    }

    @Override
    public void notifyDateSorted(List<App> apps) {
        this.apps = apps;
        appListAdapter.setApps(apps);
    }

    //    MARK: IAppListAdapter
    @Override
    public void onCardClick(App app) {
        Intent appDetail = new Intent(this, AppDetail.class);
        appDetail.putExtra(Constants.Intents.APP_DETAIL, JSONHelper.toJson(app));
        startActivity(appDetail);
    }
}
