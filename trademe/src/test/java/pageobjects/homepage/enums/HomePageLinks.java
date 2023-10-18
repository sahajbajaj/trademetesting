package pageobjects.homepage.enums;

public enum HomePageLinks {
    MOTORS("a[href='/a/motors']"),
    PROPERTY("a[href='/a/property']");

    private final String id;

    HomePageLinks(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }
}
