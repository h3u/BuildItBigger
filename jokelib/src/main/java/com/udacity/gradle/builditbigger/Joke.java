package com.udacity.gradle.builditbigger;

import java.util.Random;

/**
 * Joke providing class.
 */
public class Joke {

    /**
     * Some Chuck Norris jokes grabbed from http://api.icndb.com/jokes/random/10
     */
    private static String[] jokes = {
            "It is better to give than to receive. This is especially true of a Chuck Norris roundhouse kick.",
            "Chuck Norris grinds his coffee with his teeth and boils the water with his own rage.",
            "Who let the dogs out? Chuck Norris let the dogs out... and then roundhouse kicked them through an Oldsmobile.",
            "Chuck Norris doesn't chew gum. Chuck Norris chews tin foil.",
            "Chuck Norris built a time machine and went back in time to stop the JFK assassination. As Oswald shot, Chuck met all three bullets with his beard, deflecting them. JFK's head exploded out of sheer amazement.",
            "Chuck Norris won super bowls VII and VIII singlehandedly before unexpectedly retiring to pursue a career in ass-kicking.",
            "When Chuck Norris plays Oregon Trail, his family does not die from cholera or dysentery, but rather, roundhouse kicks to the face. He also requires no wagon, since he carries the oxen, axels, and buffalo meat on his back. He always makes it to Oregon before you.",
            "A high tide means Chuck Norris is flying over your coast. The tide is caused by God pissing his pants.",
            "Chuck Norris can hit you so hard that he can actually alter your DNA. Decades from now your descendants will occasionally clutch their heads and yell \"What The Hell was That?\".",
            "Chuck Norris doesn't say \"who's your daddy\", because he knows the answer."
    };

    /**
     * Returns one joke, hahaha :-)
     *
     * @return String
     */
    public static String tellOne() {
        return jokes[getRand()];
    }

    /**
     * Random integer between 0 and length of jokes array.
     *
     * @return int
     */
    private static int getRand() {
        Random random = new Random();
        return random.nextInt(jokes.length);
    }
}
