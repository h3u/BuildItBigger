/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.h3u.myapplication.backend;

import com.udacity.gradle.builditbigger.Joke;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

/** An endpoint class we are exposing */
@Api(name = "jokeApi", version = "v1",
    namespace = @ApiNamespace(
            ownerDomain = "backend.myapplication.h3u.example.com",
            ownerName = "backend.myapplication.h3u.example.com",
            packagePath="")
)
public class JokeEndpoint {

    /** JokeBean endpoint method that provides a joke */
    @ApiMethod(name = "provideOne")
    public JokeBean provideOne() {
        JokeBean response = new JokeBean();
        response.setData(Joke.tellOne());

        return response;
    }

}
