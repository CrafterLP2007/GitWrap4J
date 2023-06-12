# GitWrap4J-API Documentation

GitWrap4J is a wrapper API for GitHub, designed to simplify interaction with the GitHub platform using Java.

## Features

- Authenticate with GitHub using personal access tokens.
- Retrieve information about repositories, organisations and users
- Run actions for example to push a project on a repository
- Manage issues, including creating, updating, and closing issues
- Perform various operations on pull requests, such as creating, updating, and merging pull requests
- Access and manipulate repository contents, including files and directories

## Installation

To use GitWrap4J in your Java project, you can include the library as a dependency. You have two options to include the dependency:

### Maven:

```xml
<dependency>
    <groupId>de.crafterlp</groupId>
    <artifactId>gitwrap4j</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Gradle:

```groovy
dependencies {
    implementation 'de.crafterlp:gitwrap4j:1.0.0'
}
```

## Getting Started

To get started with GitWrap4J, you need to implement your own class and use GitWrap4J within it.

### InitGitWrap4J Example:

```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;

public class InitGitWrap4JExample {

    public static void main(String[] args) {
        GitWrap4J gitWrap4J = new GitWrap4J();

        // Sets the messaging
        gitWrap4J.setDebugMode(true);
    }
}
```
- The `setDebug()`-Method is used to, enable or disable the messaging.

##

### Authenticate with Github:
```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;

public class AuthenticateExample {

    public static void main(String[] args) {
        String accessToken = "your_personal_access_token";
        GitWrap4J gitWrap4J = new GitWrap4J();

        // Retrieve user information
        User user = gitWrap4J.getUser("username");

        // Authenticate with GitHub
        gitWrap4J.authorize(user, accessToken);
    }
}
```

### or:
```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;

public class AuthenticateExample {

    public static void main(String[] args) {
        String accessToken = "your_personal_access_token";
        GitWrap4J gitWrap4J = new GitWrap4J();

        // The Github username
        String userName = "userName";

        // Authenticate with GitHub
        gitWrap4J.authorize(userName, accessToken);
    }
}
```

##

### Get User:

```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;
import de.crafterlp.gitwrap4j.implementation.User;

public class AuthenticateExample {

    public static void main(String[] args) {
        GitWrap4J gitWrap4J = new GitWrap4J();

        // The Github username
        User user = gitWrap4J.getUser("userName");
        
        // Returns the email of the user
        System.out.println(user.getEmail());
    }
}
```

### Get Repository:

```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;
import de.crafterlp.gitwrap4j.implementation.Repository;
import de.crafterlp.gitwrap4j.implementation.User;

public class AuthenticateExample {

    public static void main(String[] args) {
        GitWrap4J gitWrap4J = new GitWrap4J();

        // The Github username
        Repository repository = gitWrap4J.getRepository("userName", "repoName");

        // Returns the user of the repository
        System.out.println(repository.getOwner());
    }
}
```

##

### Get Organisation:

```java
import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.User;
import de.crafterlp.gitwrap4j.implementation.Organisation;
import de.crafterlp.gitwrap4j.implementation.Repository;
import de.crafterlp.gitwrap4j.implementation.User;

public class AuthenticateExample {

    public static void main(String[] args) {
        GitWrap4J gitWrap4J = new GitWrap4J();

        // The Github username
        Organisation organisation = gitWrap4J.getOrganisation("orgName");

        // Returns the repositories in the organisation
        System.out.println(repository.getRepositories());
    }
}
```

##

## Run actions

not implemented yet

# Contributions
Contributions to GitWrap4J are welcome! If you encounter any issues or have suggestions for improvements, please open an issue on the [GitWrap4J GitHub repository](https://github.com/CrafterLP2007/GitWrap4J/issues).

# License
This project is licensed under the [MIT License](https://github.com/CrafterLP2007/GitWrap4J/blob/master/LICENCE).