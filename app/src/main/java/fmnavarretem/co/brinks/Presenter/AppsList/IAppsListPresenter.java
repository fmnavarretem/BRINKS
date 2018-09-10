package fmnavarretem.co.brinks.Presenter.AppsList;

import java.util.List;

import fmnavarretem.co.brinks.Model.POJO.App;

public interface IAppsListPresenter {
    void getApps();
    void doSortAlphebetical(List<App> apps);
    void doSortDate(List<App> apps);
}
