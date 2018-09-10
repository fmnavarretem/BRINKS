package fmnavarretem.co.brinks.Presenter.AppsList;

import java.util.List;

import fmnavarretem.co.brinks.Model.POJO.App;

public interface IAppsListListener {
    void onReceivedApps(List<App> apps);
    void onAlphabeticallySorted(List<App> apps);
    void onDateSorted(List<App> apps);
}
