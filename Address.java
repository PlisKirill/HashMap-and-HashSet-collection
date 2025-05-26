import java.util.Objects;

public class Address {
    protected String country;
    protected String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

}
