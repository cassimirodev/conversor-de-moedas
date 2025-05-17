package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtils {
    private static final Dotenv dotenv =  Dotenv.load();

    public static String getApiKey() {
        return dotenv.get("API_KEY");
    }
}
