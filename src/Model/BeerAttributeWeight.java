package Model;

public class BeerAttributeWeight 
{
    private float abv;
    private float ibu;
    private float style;
    private float ounces;

    public BeerAttributeWeight(float abv, float ibu, float style, float ounces) {
        this.abv = abv;
        this.ibu = ibu;
        this.style = style;
        this.ounces = ounces;
    }
    
    public float getAbv() {
        return abv;
    }

    public void setAbv(float abv) {
        this.abv = abv;
    }

    public float getIbu() {
        return ibu;
    }

    public void setIbu(float ibu) {
        this.ibu = ibu;
    }

    public float getStyle() {
        return style;
    }

    public void setStyle(float style) {
        this.style = style;
    }

    public float getOunces() {
        return ounces;
    }

    public void setOunces(float ounces) {
        this.ounces = ounces;
    }   
    
    public float getTotal()
    {
        return (getAbv() + getIbu() + getOunces() + getStyle());
    }
    
    
}
