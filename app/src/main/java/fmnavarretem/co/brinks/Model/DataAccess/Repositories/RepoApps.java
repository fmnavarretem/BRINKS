package fmnavarretem.co.brinks.Model.DataAccess.Repositories;

import fmnavarretem.co.brinks.Model.DataAccess.Connection.IResponder;
import fmnavarretem.co.brinks.Model.DataAccess.Connection.Proxy;
import fmnavarretem.co.brinks.Model.POJO.ItunesResponse;
import fmnavarretem.co.brinks.Util.Constants;

public class RepoApps {
    public static void getApps(IResponder responder){
        Proxy.execute(Constants.EndPoints.APPS,
                Constants.HTTPMethod.GET,
                responder,
                Constants.ServiceTag.GET_APPS,
                ItunesResponse.class);
    }
}
