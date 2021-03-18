package com.mipo.pattern.test3;

/**
 * @Classname Mp4Player
 * @Description TODO
 * @Date 2021/1/7 11:42
 * @Created by li.yy
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        //
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
