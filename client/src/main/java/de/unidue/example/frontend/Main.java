package de.unidue.example.frontend;

import com.google.gson.Gson;
import de.unidue.example.frontend.Entities.Sample;
import de.unidue.example.frontend.data.SampleEndpoint;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;
import retrofit2.Response;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main extends Application {

    public static final String BASE_URL = "http://localhost:8080";

    public static final String username = "abc";
    public static final String password = "abc";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        byte[] authHeaderB64 = Base64.encodeBase64((username + ":" + password).getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic " + new String(authHeaderB64);
        SampleEndpoint sampleEndpoint = getSampleClient(BASE_URL);

        Response<Sample> response = sampleEndpoint.createNewSample(authHeader, new Sample("SAMPLE", "SAMPLE")).execute();
        Response<List<Sample>> response2 = sampleEndpoint.getAllSamples(authHeader).execute();
        System.out.println(new Gson().toJson(response2.body()));
    }

    public static SampleEndpoint getSampleClient(String url){
        return RetrofitClient.getClient(url).create(SampleEndpoint.class);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
