package uk.co.manifesto.javasessions.dropwizard.resource;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import uk.co.manifesto.javasessions.dropwizard.api.Wine;

@Path("/api/wine")
@Produces(MediaType.APPLICATION_JSON)
public class WineResource {

	private Map<Integer, Wine> wineMap = new LinkedHashMap<>();

	public WineResource() {
		Wine sourceWine = new Wine("DRB Damien & Romain Bouchard Broc de Biques Chablis 2012","Burgundy");
		wineMap.put(sourceWine.getId(), sourceWine);
	}
	
    @GET
    public Map<Integer, Wine> getAllWine() {
        return wineMap;
    }
    
    @POST
    public Map<Integer, Wine> addNewWine(Wine wine) {
    	wineMap.put(wine.getId(), wine);
        return wineMap;
    }    
    
    @GET
    @Path("{id}")
    public Wine getWine(@PathParam("id") Integer id) {
    	if (wineMap.containsKey(id)) {
            return wineMap.get(id);    		
    	} else {
    		throw new NotFoundException("No wine here :(");
    	}
    }
    
    @DELETE
    @Path("{id}") 
    public void deleteWine(@PathParam("id") Integer id) {
    	if (wineMap.containsKey(id)) {
            wineMap.remove(id);    		
    	} else {
    		throw new NotFoundException("No wine here :(");
    	}
    }
    
    @PUT
    @Path("{id}")
    public void putWine(@PathParam("id") Integer id, Wine wine) {
    	if (wineMap.containsKey(id)) {
        	wineMap.put(id, wine);
    	} else {
    		throw new NotFoundException("No wine here :(");
    	}
    }  
}
