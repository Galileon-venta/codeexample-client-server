package de.unidue.example.frontend;

import com.google.gson.Gson;
import de.unidue.example.frontend.Entities.Sample;
import de.unidue.example.frontend.Entities.Type;
import de.unidue.example.frontend.data.SampleEndpoint;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import retrofit2.Response;

import java.io.File;
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


        File file = new File("csv.csv");
        String base64CsvString = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));

        Response<List<Sample>> csvresponse = sampleEndpoint.importSamples(authHeader ,base64CsvString).execute();
        System.out.println(new Gson().toJson(csvresponse.body()));

        // FILE TRANSFER
        //File file = new File("Server_Background.png");
        //String base64String = Base64.encodeBase64String(FileUtils.readFileToByteArray(file));

        //Response<Sample> response = sampleEndpoint.createNewSample(authHeader, new Sample("SAMPLE", "SAMPLE", Type.A, base64String, file.getName())).execute();
        //Response<List<Sample>> response2 = sampleEndpoint.getAllSamples(authHeader).execute();
        //Sample sample = response.body();
        //sample.setBase64String("Hallo");
        //System.out.println(new Gson().toJson(sample));
        //System.out.println(new Gson().toJson(response2.body()));
        //byte[] decoded = Base64.decodeBase64(sample.getBase64String());
        //FileUtils.writeByteArrayToFile(new File(sample.getFileName()), decoded);

    }

    public static SampleEndpoint getSampleClient(String url){
        return RetrofitClient.getClient(url).create(SampleEndpoint.class);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
