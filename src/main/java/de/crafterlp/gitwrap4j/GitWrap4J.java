package de.crafterlp.gitwrap4j;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.crafterlp.gitwrap4j.actions.Action;
import de.crafterlp.gitwrap4j.auth.Authorization;
import de.crafterlp.gitwrap4j.exceptions.AuthorizationException;
import de.crafterlp.gitwrap4j.exceptions.ExecuteException;
import de.crafterlp.gitwrap4j.implementation.User;
import de.crafterlp.gitwrap4j.utils.web.GitHubPoster;
import de.crafterlp.gitwrap4j.utils.web.GitHubRequester;
import lombok.Getter;

public class GitWrap4J {

    public static String BASE_URL = "https://api.github.com";
    private Gson gson;
    public static boolean debug = true;
    private JsonObject requestObject;
    @Getter
    private final GitHubPoster gitHubPoster;
    @Getter
    private final GitHubRequester gitHubRequester;




    /**
     *
     * A default constructor
     *
     */
    public GitWrap4J() {
        gitHubPoster = new GitHubPoster();
        gitHubRequester = new GitHubRequester();
    }


    /**
     *
     * sets the messaging
     * @param debugMode : The boolean, if you want to activate or deactivate the debugMode
     *
     */
    public void setDebugMode(boolean debugMode) {
        debug = debugMode;
    }


    /**
    *
    * returns the user-class
    * @param userName : The Github-UserName
    *
     */
    public User getUser(String userName) {
        requestObject = new JsonObject();
        requestObject = gitHubRequester.request("/users/" + userName);

        gson = new Gson();
        return gson.fromJson(requestObject, User.class);
    }


    /**
     *
     * send a user authentication
     * @param user : The User to authenticate
     * @param accessKey : The accessKey of the user
     *
     */
    public void authorize(User user, String accessKey) {
        Authorization authorization = new Authorization(user, accessKey);
        try {
            authorization.sendAuthorization();
        } catch (AuthorizationException e) {
            throw new RuntimeException(e);
        }
    }

    public void authorize(String userName, String accessKey) {
        Authorization authorization = new Authorization(userName, accessKey);
        try {
            authorization.sendAuthorization();
        } catch (AuthorizationException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *
     * executes an action for example a PushAction
     * @param action : The Action-Class
     *
     */
    public void execute(Action action) throws ExecuteException {
        Action.executeAction(action);
    }


    /**
     *
     * returns the Base-API-Url of GitHub
     *
     */
    public String getBaseUrl() {
        return BASE_URL;
    }

}