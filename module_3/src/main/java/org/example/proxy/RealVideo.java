package org.example.proxy;

public class RealVideo implements Video {
    private final String fileName;

    public RealVideo(String fileName) {
        this.fileName = fileName;

        loadVideoFromResources();
    }

    private void loadVideoFromResources() {
        // Hidden heavy operation;
        System.out.println("(HIDDEN PROCESS) Loading video file from disk: " + fileName);
    }

    @Override
    public void run() {
        System.out.println("Run video file: " + fileName);
    }

    @Override
    public void stop() {
        System.out.println("Stop video file: " + fileName);
    }

    @Override
    public void pause() {
        System.out.println("Pause video file: " + fileName);
    }
}
