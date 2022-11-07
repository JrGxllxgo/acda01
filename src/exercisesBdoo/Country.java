package exercisesBdoo;

public class Country {

    private int id;
    private String countryName;

    Country(int id, String countryName){
        this.id = id;
        this.countryName = countryName;
    }

    //GETTERS Y SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
