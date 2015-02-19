package com.github.asufana;

import java.util.*;

import org.apache.http.client.fluent.*;
import org.apache.http.message.*;

import com.github.asufana.exceptions.*;

public class HttpClient {
    
    public static Content get(final String token, final String url) throws SqwiggleException {
        final BasicHeader basicAuthHeader = createAuthHeader(token);
        try {
            return Request.Get(url)
                          .setHeader(basicAuthHeader)
                          .execute()
                          .returnContent();
        }
        catch (final Exception e) {
            throw new SqwiggleException(e);
        }
    }
    
    private static BasicHeader createAuthHeader(final String token) {
        final String credential = createCredential(token);
        return new BasicHeader("Authorization", "Basic " + credential);
    }
    
    private static String createCredential(final String token) {
        final String basicAuthString = String.format("%s:X", token);
        return Base64.getEncoder().encodeToString(basicAuthString.getBytes());
    }
}
