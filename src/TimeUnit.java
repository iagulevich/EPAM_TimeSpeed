public enum TimeUnit {

    HOURS("h"),
    MINUTES("m"),
    SECONDS("s");

    private String name;

    TimeUnit(String name) {
        this.name = name;
    }

    boolean hmsBool(String s){
        /*switch (s){
            case "h": return true;
            case "m": return true;
            case "s": return true;
        }
        return false;*/
        return "hms".contains(s);
    }


}
