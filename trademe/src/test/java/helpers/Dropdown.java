package helpers;

public enum Dropdown {
    MAKE(" Make "),
    LOCATION(" Location ");

    private final String id;

    Dropdown(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
