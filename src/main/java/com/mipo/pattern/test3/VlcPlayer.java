package com.mipo.pattern.test3;

/**
 * @Classname VlcPlayer
 * @Description TODO
 * @Date 2021/1/7 11:41
 * @Created by li.yy
 */
public class VlcPlayer implements AdvancedMediaPlayer {

    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
