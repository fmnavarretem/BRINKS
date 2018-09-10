package fmnavarretem.co.brinks.Model.DataAccess.Connection;

import java.util.Map;

import fmnavarretem.co.brinks.Util.Constants;
import fmnavarretem.co.brinks.Util.JSONHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Proxy {
    public static void execute(String url,
                               Constants.HTTPMethod methodType,
                               final IResponder responder,
                               final Constants.ServiceTag serviceTag,
                               final Class<?> type) {

        IProxyMembers proxyMembers = ProxyAdapter.startConnection(Constants.EndPoints.URL_ROOT);
        Call<Object> call;
        switch (methodType){
            case GET:
                call = proxyMembers.getData(url);
                break;
            default:
                call = null;
                break;
        }
        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {
                Object object = JSONHelper.objectFromJson(response.body(),type);
                responder.onSuccessResponse(object,serviceTag);
            }

            @Override
            public void onFailure(Call<Object> call, Throwable t) {
                responder.onFailedResponse();
            }
        });
    }
}
