package com.sample;

public class SingletonSample {

    private static SingletonSample instance;

    public String str;

    private SingletonSample() {
    }

    public static SingletonSample getSingleInstance() {
        if (instance == null) {
            instance = new SingletonSample();
        }
        return instance;
    }
}
