package com.mipo.pattern.test1;

/**
 * @Classname Cricket
 * @Description TODO
 * @Date 2021/1/7 10:30
 * @Created by li.yy
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
