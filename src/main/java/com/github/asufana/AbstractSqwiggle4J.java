package com.github.asufana;

import java.util.*;

import org.apache.http.client.fluent.*;

import rx.*;
import rx.Observable;
import rx.functions.*;

import com.google.gson.reflect.*;

public abstract class AbstractSqwiggle4J {
    
    protected <T> Observable<T> request(final String token,
                                        final String url,
                                        final TypeToken<T> typeToken) {
        return Observable.create(new RequestSubscriber(token, url))
                         .map(content -> Response.parse(content))
                         .map(response -> response.toObject(typeToken));
    }
    
    protected <T> Observable<T> flat(final Observable<List<T>> entities) {
        return entities.flatMap(new Func1<List<T>, rx.Observable<T>>() {
            @Override
            public rx.Observable<T> call(final List<T> entities) {
                return rx.Observable.from(entities);
            }
        });
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
