package de.crafterlp.gitwrap4j.utils.web;

import com.google.gson.Gson;
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.utils.messages.MessageType;
import de.crafterlp.gitwrap4j.utils.messages.MessageUtils;
import okhttp3.*;

import java.io.IOException;

public class GitHubPoster {

    private OkHttpClient client;
    private Gson gson;
    public boolean isSuccessfully;
    public GitHubPoster() {
        client = new OkHttpClient();
        gson = new Gson();
    }

    public void post(String subUrl, Object data) {
        String url = GitWrap4J.BASE_URL + subUrl;
        String jsonData = gson.toJson(data);

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), jsonData);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        try(Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                MessageUtils.sendMessage(MessageType.ERROR, "Request failed with HTTP error code: " + response.code());
                return;
            }
            isSuccessfully = true;
            MessageUtils.sendMessage(MessageType.SUCCESS, "Successfully posted: " + data + " on url: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void postHeader(String subUrl, String header, Object data) {
        String url = GitWrap4J.BASE_URL + subUrl;
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(url)
                .header(header, data.toString())
                .build();

        try(Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                MessageUtils.sendMessage(MessageType.ERROR, "Request failed with HTTP error code: " + response.code());
                return;
            }
            isSuccessfully = true;
            MessageUtils.sendMessage(MessageType.SUCCESS, "Successfully posted header: " + header + " with data: " + data + " on url: " + url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
