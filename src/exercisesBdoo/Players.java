package exercisesBdoo;

public class Players {
    private String name;
    private Country myCountry;
    private String sport;
    private int age;

    public Players(String name, String sport, Country myCountry, int age){
        this.name=name;
        this.myCountry=myCountry;
        this.sport=sport;
        this.age=age;
    }

    //GETTERS Y SETTERS

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return myCountry;
    }

    public void setCountry(String country) {
        this.myCountry = myCountry;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
