package org.example.adapter;

public class LegacyLoggerAdapter implements Logger {
    private final LegacyLogger legacyLogger;
    private static final int INFO_LEVEL = 1;

    public LegacyLoggerAdapter(LegacyLogger legacyLogger) {
        this.legacyLogger = legacyLogger;
    }

    @Override
    public void logMessage(String message) {
        legacyLogger.writeMessageToDisk(INFO_LEVEL, message);
    }
}
