package ImManagerClass;

public class Person
{
    private String firstName;
    private String lastName;
    private String registre;
    private String adress;

    /**
     * @param firstName
     * @param lastName
     * @param registre
     * @param adress
     */
    public Person (String firstName, String lastName, String registre, String adress)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setRegistre(registre);
        setAdress(adress);
    }


    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getAdress()
    {
        return adress;
    }

    public String getRegistre()
    {
        return registre;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setRegistre(String registre)
    {
        this.registre = registre;
    }

    public void setAdress(String adress)
    {
        this.adress = adress;
    }
}



