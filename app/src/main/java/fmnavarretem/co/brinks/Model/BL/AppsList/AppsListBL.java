package fmnavarretem.co.brinks.Model.BL.AppsList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fmnavarretem.co.brinks.Model.DataAccess.Connection.IResponder;
import fmnavarretem.co.brinks.Model.DataAccess.Repositories.RepoApps;
import fmnavarretem.co.brinks.Model.POJO.App;
import fmnavarretem.co.brinks.Model.POJO.ItunesResponse;
import fmnavarretem.co.brinks.Presenter.AppsList.IAppsListListener;
import fmnavarretem.co.brinks.Util.Constants;

public class AppsListBL implements IAppsListBL {

    private IAppsListListener listener;

    public AppsListBL(IAppsListListener listener) {
        this.listener = listener;
    }

    //    MARK: IAppsListBL
    @Override
    public void getApps() {
        RepoApps.getApps(this);
    }

    @Override
    public void sortAlphebetical(List<App> apps) {
        List<App> appsSort = new ArrayList<>();
        List<String> namesApp = new ArrayList<>();
        for (App app: apps){
            namesApp.add(app.getImName().getLabel());
        }
        Collections.sort(namesApp);
        for (String name: namesApp){
            for (App app: apps){
                if (name.equals(app.getImName().getLabel())){
                    appsSort.add(app);
                }
            }
        }
        listener.onAlphabeticallySorted(appsSort);
    }

    @Override
    public void doSortDate(List<App> apps) {
        List<App> appsSort = new ArrayList<>();
        List<String> datesApp = new ArrayList<>();
        for (App app: apps){
            String date = app.getImReleaseDate().getLabel();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            try {
                datesApp.add(Long.toString(dateFormat.parse(date).getTime()));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        Collections.sort(datesApp);
        for (String date: datesApp){
            for (App app: apps){
                if (date.equals(app.getImName().getLabel())){
                    appsSort.add(app);
                }
            }
        }
        listener.onDateSorted(apps);
    }

    //    MARK: IResponder
    @Override
    public void onSuccessResponse(Object objectResponse, Constants.ServiceTag serviceTag) {
        switch (serviceTag){
            case GET_APPS:
                listener.onReceivedApps(((ItunesResponse)objectResponse).getFeed().getEntry());
                break;
        }
    }

    @Override
    public void onFailedResponse() {

    }
}
