package ImManagerClass;

public class Apartment
{
    private int id;
    private String name;
    private String city;
    private String adress;
    private String postal_code;


    public Apartment(int id, String name, String city, String adress, String postal_code)
    {
        this.id = id;
        setName(name);
        setCity(city);
        setAdress(adress);
        setPostalCode(postal_code);
    }

    private void setPostalCode(String postal_code)
    {
        this.postal_code=postal_code;
    }

    private void setAdress(String adress)
    {
        this.adress=adress;
    }

    private void setCity(String city)
    {
        this.city=city;
    }

    private void setName(String name)
    {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getAdress() {
        return adress;
    }

    public String getPostal_code() {
        return postal_code;
    }
}
