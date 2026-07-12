package com.muhammedshopkart.data.secrets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Secrets {
    private static final Properties local = new Properties();
    private static boolean loaded = false;

    private static void loadLocalIfPresent() {
        if (loaded) return;
        loaded = true;
        try (InputStream in = Secrets.class.getClassLoader()
                .getResourceAsStream("secrets.local.properties")) {
            if (in != null) local.load(in);
        } catch (IOException ignored) {
            // absent in CI — that's expected, env vars or CI store take over
        }
    }

    /**
     * Loading Secrets to the CI ignore the local file in teh git
     */
    public static String get(String key) {
        String envKey = key.toUpperCase().replace('.', '_'); //
        String fromEnv = System.getenv(envKey);
        if (fromEnv != null && !fromEnv.isBlank()) return fromEnv;

        loadLocalIfPresent();
        String fromLocal = local.getProperty(key);
        if (fromLocal != null && !fromLocal.isBlank()) return fromLocal;

        throw new IllegalStateException(
                "Secret not found for key '" + key + "'. Set env var " + envKey +
                        " or add it to secrets.local.properties (git-ignored)."
        );
    }
}