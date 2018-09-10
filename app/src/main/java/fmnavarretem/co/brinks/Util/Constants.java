package fmnavarretem.co.brinks.Util;

public class Constants {
    public static class EndPoints{
        public static String URL_ROOT = "https://itunes.apple.com/us/rss/toppaidapplications/";
        public static String APPS = "limit=20/json";
    }
    public enum ServiceTag{
        GET_APPS
    }
    public enum HTTPMethod{
        GET
    }
    public static class Intents{
        public static String APP_DETAIL = "APP_DETAIL";
    }
}
