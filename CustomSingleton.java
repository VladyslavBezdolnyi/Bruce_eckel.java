package com.company;

public class CustomSingleton {
    private static boolean isObjectCreated;
    private static CustomSingleton machineLink;

    int wheels;
    float speed;

    private CustomSingleton(int wheels, float speed){

        this.wheels = wheels; this.speed = speed;
        isObjectCreated = true;
    }

    static public CustomSingleton createMachine(int wheels, float speed){

        if (!isObjectCreated){
            machineLink = new CustomSingleton(wheels, speed);
        }
        return machineLink;
    }
}
