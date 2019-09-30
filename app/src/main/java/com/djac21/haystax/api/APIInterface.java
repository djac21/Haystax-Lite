package com.djac21.haystax.api;

import com.djac21.haystax.model.IncidentDetailModel;
import com.djac21.haystax.model.IncidentsListModel;
import com.djac21.haystax.model.LoginModel;
import com.djac21.haystax.model.IncidentImageModel;
import com.google.gson.JsonObject;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIInterface {
    @Headers("Content-Type: application/json")
    @POST("/server/gate/login")
    Call<LoginModel> login(@Body JsonObject jsonObject);

    @POST("/server/gate/logout")
    Single<LoginModel> logout();

    @GET("/server/api/incidents")
    Call<IncidentsListModel> getIncidents(@Header("Cookie") String cookie);

    @GET("/server/api/incidents/{incident_id}")
    Single<IncidentDetailModel> getIncident(@Header("Cookie") String cookie, @Path("incident_id") String incident_id);

    @GET("/server/api/links?type=attached_files")
    Single<IncidentImageModel> getImage(@Header("Cookie") String cookie, @Query("from") String from);
}