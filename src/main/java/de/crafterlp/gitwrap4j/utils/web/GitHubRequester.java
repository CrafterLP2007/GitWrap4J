package de.crafterlp.gitwrap4j.utils.web;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.utils.messages.MessageType;
import de.crafterlp.gitwrap4j.utils.messages.MessageUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class GitHubRequester {

    private OkHttpClient client;

    public GitHubRequester() {
        client = new OkHttpClient();
    }

    public JsonObject request(String subUrl) {
        String url = GitWrap4J.BASE_URL + subUrl;
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()){
            if (response.isSuccessful()) {
                String jsonResponse = response.body().string();
                MessageUtils.sendMessage(MessageType.SUCCESS, "Successfully requested: " + url);

                return JsonParser.parseString(jsonResponse).getAsJsonObject();
            } else {
                MessageUtils.sendMessage(MessageType.ERROR, "Request failed with HTTP error code: " + response.code());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

}
