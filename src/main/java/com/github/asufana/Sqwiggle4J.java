package com.github.asufana;

import rx.*;

import com.github.asufana.resources.*;
import com.google.gson.reflect.*;

public class Sqwiggle4J extends AbstractSqwiggle4J {
    
    public static final String BASE_URL = "https://api.sqwiggle.com";
    private final String token;
    
    public Sqwiggle4J(final String token) {
        this.token = token;
    }
    
    public Observable<User> user(final Integer userId) {
        return request(token,
                       BASE_URL + "/users/" + userId.toString(),
                       new TypeToken<User>() {});
    }
}
