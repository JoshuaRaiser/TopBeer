package Model;

public class BeerSimilarity 
{

    private Beer beer;
    private float similarity;

    public BeerSimilarity(Beer beer, float similarity)
    {
        this.beer = beer;
        this.similarity = similarity;
    }

    public Beer getBeer() {
        return beer;
    }

    public void setBeer(Beer beer) {
        this.beer = beer;
    }

    public float getSimilarity() {
        return similarity;
    }

    public void setSimilarity(float similarity) {
        this.similarity = similarity;
    }   
    
    @Override
    public String toString() {
        return "similarity=" + similarity + '}';
    }
    
}
