package de.crafterlp.gitwrap4j.utils;

import de.crafterlp.gitwrap4j.GitWrap4J;
import de.crafterlp.gitwrap4j.implementation.User;

public class TempStorage {

    public static void main(String[] args) {
        GitWrap4J gitWrap4J = new GitWrap4J();
        User user = gitWrap4J.getUser("RealZone22");
        System.out.println(user.getEmail());

    }

}
