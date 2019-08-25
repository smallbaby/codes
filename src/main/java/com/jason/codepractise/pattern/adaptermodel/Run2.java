package com.jason.codepractise.pattern.adaptermodel;

import sun.audio.AudioPlayer;

/**
 * author: zhangkai
 * date: 2019-08-25
 * description:
 */
public class Run2 {
    public static void main(String[] args) {
        MediaPlayer audioPlayer = new MediaAdapter("mp4");
        audioPlayer.play("mp4", " x.mp4");
        audioPlayer = new MediaAdapter("vlc");
        audioPlayer.play("vlc", "xx.vlc");

    }
}

interface MediaPlayer {
    void play(String audioType, String fileName);
}

interface AdvanceMediaPlayer {
    void playVic(String fileName);

    void playMp4(String fileName);
}

class VicPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVic(String fileName) {
        System.out.println("playing vlc file . name: " + fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // donothing
    }
}

class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVic(String fileName) {
        //do nothing.
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("playing mp4 file . name: " + fileName);
    }
}

class MediaAdapter implements MediaPlayer {
    AdvanceMediaPlayer advanceMediaPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equals("vlc")) {
            advanceMediaPlayer = new VicPlayer();
        } else if (audioType.equals("mp4")) {
            advanceMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.toLowerCase().equals("vlc")) {
            advanceMediaPlayer.playVic(fileName);
        } else if (audioType.toLowerCase().equals("mp4")) {
            advanceMediaPlayer.playMp4(fileName);
        }
    }
}
