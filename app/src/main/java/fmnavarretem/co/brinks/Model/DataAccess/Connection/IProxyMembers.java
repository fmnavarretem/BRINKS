package fmnavarretem.co.brinks.Model.DataAccess.Connection;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IProxyMembers {
    @GET
    Call<Object> getData(@Url String patch);
}
