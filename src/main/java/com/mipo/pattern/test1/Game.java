package com.mipo.pattern.test1;

/**
 * @Classname Game
 * @Description TODO
 * @Date 2021/1/7 10:29
 * @Created by li.yy
 */
public abstract class Game {

    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    /**
     * 模板方法
     */
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
