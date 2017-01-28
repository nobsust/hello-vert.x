package com.github.nobsust.vertx.first;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

/**
 * Created by Sam on 1/28/2017.
 */
public class MyFirstVerticle extends AbstractVerticle {

    @Override
    public void start(Future<Void> future) throws Exception {
        vertx
                .createHttpServer()
                .requestHandler(r -> {
                    r.response().end("<h1>Hello from my first Vert.x 3 application</h1>");
                })
                .listen(
                        // Retrieve the port from the configuration,
                        // default to 8080.
                        config().getInteger("http.port", 8080), result -> {
                            if (result.succeeded()) {
                                future.complete();
                            } else {
                                future.fail(result.cause());
                            }
                        });
    }
}
