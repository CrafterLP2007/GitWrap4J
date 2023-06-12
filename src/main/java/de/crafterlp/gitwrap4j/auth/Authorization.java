package de.crafterlp.gitwrap4j.auth;

import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.exceptions.AuthorizationException;
import de.crafterlp.gitwrap4j.implementation.User;
import de.crafterlp.gitwrap4j.utils.messages.MessageType;
import de.crafterlp.gitwrap4j.utils.messages.MessageUtils;
import okhttp3.Credentials;

import java.util.HashMap;
import java.util.Map;

public class Authorization {

    protected String userName;
    protected String accessToken;
    public Map<String, String> authenticatedUsers = new HashMap<>();

    public Authorization(User user, String accessToken) {
        this.userName = user.getName();
        this.accessToken = accessToken;
    }

    public Authorization(String userName, String accessToken) {
        this.userName = userName;
        this.accessToken = accessToken;
    }

    public void sendAuthorization() throws AuthorizationException {
        GitWrap4J gitWrap4J = new GitWrap4J();

        String credentials = Credentials.basic(userName, accessToken);

        gitWrap4J.getGitHubPoster().postHeader("/user", "Authorization", credentials);

        if (!gitWrap4J.getGitHubPoster().isSuccessfully) {
            MessageUtils.sendMessage(MessageType.ERROR, "Error while logging into your Github account. Please check the credentials!");
            return;
        }
        MessageUtils.sendMessage(MessageType.SUCCESS, "Successfully logged in as: " + userName);
        authenticatedUsers.put(userName, accessToken);
    }


}
