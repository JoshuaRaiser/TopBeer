package RBC;

import Model.Beer;
import Model.BeerAttributeWeight;
import Model.BeerSimilarity;
import Model.BreweryManager;
import Util.CSVReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RBCTopBeer 
{
    private List<Beer> beers = new ArrayList<>();
    private Set<String> styles = new TreeSet<>();
    private Set<Float> ounces = new TreeSet<>();
    private List<BeerSimilarity> beerSimilarity = new ArrayList<>();
    
    /**
     * Constructor for RBCTopBeer
     * @throws IOException 
     */
    public RBCTopBeer() throws IOException 
    {
        List<String[]> beerList =  new CSVReader().read("beers", true);
        BreweryManager bm = new BreweryManager();
        
        for(String[] row : beerList)
        {
            Beer beer = new Beer();
            beer.setAbv(row[0].equalsIgnoreCase("") ? 0 : Float.parseFloat(row[0]));
            beer.setIbu(row[1].equalsIgnoreCase("") ? 0 : Float.parseFloat(row[1]));
            beer.setId(Integer.parseInt(row[2]));
            beer.setName(row[3]);
            beer.setStyle(row[4]);
            beer.setBrewery(bm.getBrewery(Integer.parseInt(row[5])));
            beer.setOunces(Float.parseFloat(row[6]));
            
            beers.add(beer);
            styles.add(beer.getStyle());
            ounces.add(beer.getOunces());
        }   
    }   
        
    /**
     * Calculate numeric similarity
     * @param a1 Float
     * @param a2 Float
     * @param max Float
     * @param min Float
     * @return Float
     */
    private float NumericSimilarity(float a1, float a2, float max, float min)
    {
        return (1 - (Math.abs(a2 - a1) / (max - min)));
    }
    
    /**
     * Calculate symbolic similarity
     * @param a1 String
     * @param a2 String
     * @return Float
     */
    private float SymbolicSimilarity(String a1, String a2)
    {
        return (a1.equals(a2) ? 1 : 0);
    }
    
    /**
     * @param newBeer
     * @param weight
     * @return  SimilarBeers
     */
    public void process(Beer newBeer, BeerAttributeWeight weight)
    {
        List<BeerSimilarity> similarBeers = new ArrayList<>();
        
        for(Beer beer : beers)
        {
            similarBeers.add(similarity(newBeer, beer, weight));
        }
        
        // order by similarity
        Collections.sort(similarBeers, (sb1, sb2) ->
        {
            return sb1.getSimilarity() >= sb2.getSimilarity() ? -1 : 1;
        });
        
        beerSimilarity = similarBeers;
    }
    
    /**
     * @param newBeer
     * @param beer
     * @param weight
     * @return BeerSimilarity
     */
    private BeerSimilarity similarity(Beer newBeer, Beer beer, BeerAttributeWeight weight)
    {
        float sumSimilarity;
        
        sumSimilarity = weight.getAbv() * NumericSimilarity(beer.getAbv(), newBeer.getAbv()/100, (float)12.5, (float)2.7);
        sumSimilarity += weight.getIbu()* NumericSimilarity(beer.getIbu(), newBeer.getIbu(), (float)138, (float)10);
        sumSimilarity += weight.getStyle() * SymbolicSimilarity(beer.getStyle(), newBeer.getStyle());
        sumSimilarity += weight.getOunces()* NumericSimilarity(beer.getOunces(), newBeer.getOunces(), (float)32, (float)8.4);
        
        return new BeerSimilarity(beer, sumSimilarity/weight.getTotal());
    }

    public Set<String> getStyles() 
    {
        return styles;
    }

    public List<Beer> getBeers() 
    {
        return beers;
    }
    
    public Set<Float> getOunces()
    {
        return ounces;
    }
    
    public List<BeerSimilarity> getBeerSimilarity() {
        return beerSimilarity;
    }
    
}
