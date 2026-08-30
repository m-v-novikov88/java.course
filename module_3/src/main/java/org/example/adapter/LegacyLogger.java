package org.example.adapter;

// Adaptee Class(Third-party lib with incompatible interface)
public class LegacyLogger {
    public void writeMessageToDisk(int logLevel, String message) {
        System.out.println("[LOG_LEVEL=" + logLevel + "]: " + message);
    }
}
