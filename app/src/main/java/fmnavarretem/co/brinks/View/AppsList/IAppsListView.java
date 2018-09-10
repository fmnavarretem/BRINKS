package fmnavarretem.co.brinks.View.AppsList;

import java.util.List;

import fmnavarretem.co.brinks.Model.POJO.App;

public interface IAppsListView {
    void notifyReceivedApps(List<App> apps);
    void notifyAlphabeticallySorted(List<App> apps);
    void notifyDateSorted(List<App> apps);
}
