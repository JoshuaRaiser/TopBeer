package Model;

public class Beer 
{
    private int id;
    
    private float abv;
    private float ibu;
    private String name;
    private String style;
    private Brewery brewery;
    private float ounces;

    public float getAbv() {
        return abv;
    }

    @Override
    public String toString() {
        return "ABV: " + abv + "\tIBU: " + ibu + "\tStyle: " + style + "\tOz: " + ounces;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getIbu() {
        return ibu;
    }

    public void setIbu(float ibu) {
        this.ibu = ibu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Brewery getBrewery() {
        return brewery;
    }

    public void setBrewery(Brewery brewery) {
        this.brewery = brewery;
    }

    public float getOunces() {
        return ounces;
    }

    public void setOunces(float ounces) {
        this.ounces = ounces;
    }    
        
}
