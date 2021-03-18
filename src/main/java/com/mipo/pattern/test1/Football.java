package com.mipo.pattern.test1;

/**
 * @Classname Football
 * @Description TODO
 * @Date 2021/1/7 10:31
 * @Created by li.yy
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
