package org.example.apisEjemplos;

public class ElTiempo {
    public double latitude;
    public double longitude;
    public double generationtime_ms;
    public int utc_offset_seconds;
    public String timezone;
    public String timezone_abbreviation;
    public double elevation;
    CurrentWeather current_weather;

    static class CurrentWeather{
        public String time;
        public int interval;
        public double temperature;
        public double windspeed;
        public int winddirection;
        public int is_day;
        public int weathercode;

    }
}