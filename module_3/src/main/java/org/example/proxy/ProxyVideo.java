package org.example.proxy;

public class ProxyVideo implements Video {
    private RealVideo realVideo;
    private final String fileName;

    public ProxyVideo(String fileName) {
        this.fileName = fileName;
        // Here we don't load the video yet;
    }

    private void lazyRealVideoInit() {
        if (realVideo == null) {
            realVideo = new RealVideo(fileName);
        }
    }

    @Override
    public void run() {
        lazyRealVideoInit();
        realVideo.run();
    }

    @Override
    public void stop() {
        lazyRealVideoInit();
        realVideo.stop();
    }

    @Override
    public void pause() {
        lazyRealVideoInit();
        realVideo.pause();
    }
}
