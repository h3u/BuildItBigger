package com.udacity.gradle.builditbigger.test;

import com.udacity.gradle.builditbigger.Joke;

/**
 * Test class Joke
 */
public class JokeTest {

    @org.junit.Test
    public void testTellOne() throws Exception {

        String joke = Joke.tellOne();
        assert(joke.length() != 0);
    }
}