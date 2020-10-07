package com.example.tesy.music;

public interface IServicer {
        void PlayItem();

        void getUpDataStuats();

        boolean isPlaying();

        int getDuration();

        int getProgess();


        void seekTo(int i);

        void ipdatamodel();

        int getModel();

        void playPre();

        void playNext();
}
