package fmnavarretem.co.brinks.Presenter.AppsList;

import java.util.List;

import fmnavarretem.co.brinks.Model.BL.AppsList.AppsListBL;
import fmnavarretem.co.brinks.Model.BL.AppsList.IAppsListBL;
import fmnavarretem.co.brinks.Model.POJO.App;
import fmnavarretem.co.brinks.View.AppsList.IAppsListView;

public class AppsListPresenter implements IAppsListPresenter, IAppsListListener {

    private IAppsListView view;
    private IAppsListBL bl;

    public AppsListPresenter(IAppsListView view) {
        this.view = view;
        bl = new AppsListBL(this);
    }

    //    MARK: IAppsListPresenter
    /**
     * Use this function to get the Apps List from the web service
    */
    @Override
    public void getApps() {
        bl.getApps();
    }

    /**
     * Use this function in sorting alphebetically the apps list
     */
    @Override
    public void doSortAlphebetical(List<App> apps) {
        bl.sortAlphebetical(apps);
    }

    /**
     * Use this function sort by date the apps list
     */
    @Override
    public void doSortDate(List<App> apps) {
        bl.doSortDate(apps);
    }

    //    MARK: IAppsListListener
    /**
     * this function is calling when the app list is received from the web service
     */
    @Override
    public void onReceivedApps(List<App> apps) {
        view.notifyReceivedApps(apps);
    }

    /**
     * this function is calling when the app list is sorted by alphabetic.
     */
    @Override
    public void onAlphabeticallySorted(List<App> apps) {
        view.notifyAlphabeticallySorted(apps);
    }

    /**
     * this function is calling when the app list is sorted by date.
     */
    @Override
    public void onDateSorted(List<App> apps) {
        view.notifyDateSorted(apps);
    }
}
