package pageobjects.motorspage.models;

public class Car {
    public String name;
    public Integer minResultsNumber;
    public Integer maxResultsNumber;

    public Car(String name, Integer minResultsNumber, Integer maxResultsNumber) {
        this.name = name;
        this.minResultsNumber = minResultsNumber;
        this.maxResultsNumber = maxResultsNumber;
    }
}
