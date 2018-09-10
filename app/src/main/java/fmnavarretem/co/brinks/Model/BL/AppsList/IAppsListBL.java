package fmnavarretem.co.brinks.Model.BL.AppsList;

import java.util.List;

import fmnavarretem.co.brinks.Model.DataAccess.Connection.IResponder;
import fmnavarretem.co.brinks.Model.POJO.App;

public interface IAppsListBL extends IResponder {
    void getApps();
    void sortAlphebetical(List<App> apps);
    void doSortDate(List<App> apps);
}
