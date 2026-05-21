package org.example.practica2;

public class Pokemon {

    public String name;
    public int height;
    public int weight;
    public Stat[] stats;
    public Type[] types;


    static class Stat {
        public int base_stat;
        public Stat2 stat;

        static class Stat2 {
            public String name;
        }
    }

    static class Type {
        public Type2 type;

        static class Type2 {
            public String name;
        }
    }
}