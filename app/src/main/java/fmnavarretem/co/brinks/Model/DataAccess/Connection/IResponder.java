package fmnavarretem.co.brinks.Model.DataAccess.Connection;

import fmnavarretem.co.brinks.Util.Constants;

public interface IResponder {
    void onSuccessResponse(Object objectResponse, Constants.ServiceTag serviceTag);
    void onFailedResponse();
}
