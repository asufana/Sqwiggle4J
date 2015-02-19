package com.github.asufana;

import org.apache.http.client.fluent.*;

import rx.*;

import com.google.gson.reflect.*;

public abstract class AbstractSqwiggle4J {
    
    protected <T> Observable<T> request(final String token,
                                        final String url,
                                        final TypeToken<T> typeToken) {
        return Observable.create(new RequestSubscriber(token, url))
                         .map(content -> Response.parse(content))
                         .map(response -> response.toObject(typeToken));
    }
    
    private static class RequestSubscriber implements Observable.OnSubscribe<Content> {
        private final String token;
        private final String url;
        
        public RequestSubscriber(final String token, final String url) {
            this.token = token;
            this.url = url;
        }
        
        @Override
        public void call(final Subscriber<? super Content> subscriber) {
            try {
                final Content content = HttpClient.get(token, url);
                subscriber.onNext(content);
            }
            catch (final Exception e) {
                subscriber.onError(e);
            }
            subscriber.onCompleted();
        }
    }
}
