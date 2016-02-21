# Build it Bigger

This project is an [Udacity](https://www.udacity.com/) [Nanodegree](https://www.udacity.com/nanodegree) exercise,
that mainly deals with the usage of [gradle](http://gradle.org/), multi-module building with android & java libraries and
handling a Google Cloud Endpoint.   

A full description of all features covered can be found [here](https://github.com/udacity/ud867/tree/master/FinalProject).

## Structure

- `app/` - the main Android app that uses all modules
- `jokelib/` - a java library that provides jokes
- `androidjokelibrary/` - an android library that displays a joke
- `jokeProvider/` - a Google Cloud Endpoint providing jokes (from jokelib)