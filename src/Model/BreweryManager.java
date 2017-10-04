package Model;

import Util.CSVReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreweryManager 
{
    
    private final Map<Integer, Brewery> breweries;
    
    public BreweryManager() throws IOException 
    {
        breweries = new HashMap<>();
        
        // Nesta linha, ler o arquivo csv das cervejarias e adicioná-las ao map
        List<String[]> brewList = new CSVReader().read("breweries", true);
        
        for (String[] rows : brewList)
        {
            Brewery brewery = new Brewery();
            brewery.setName(rows[1]);
            brewery.setCity(rows[2]);
            brewery.setState(rows[3]);
            
            breweries.put(Integer.parseInt(rows[0]), brewery);
        }       
        
    }
    
    public Brewery getBrewery(int id)   
    {
        if (breweries.containsKey(id))
        {
            return breweries.get(id);
        }
        
        return null;
    }
    
}
