package de.unidue.example.frontend.data;


import de.unidue.example.frontend.Entities.Sample;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface SampleEndpoint {

    @GET("/v1/samples/{id}")
    Call<Sample> getSampleById(@Header("Authorization") String auth, @Path("id") Integer id);

    @GET("/v1/samples/all")
    Call<List<Sample>> getAllSamples(@Header("Authorization") String auth);

    @POST("/v1/samples/new")
    Call<Sample> createNewSample(@Header("Authorization") String auth, @Body Sample sample);

}
