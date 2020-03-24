package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.dao.EsameDAO;

public class Model {
    EsameDAO dao = new EsameDAO();
    List <Esame> parziale = new LinkedList <Esame >();
    int M=0;
    
	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
	    List <Esame> lE = new LinkedList <Esame >(dao.getTuttiEsami());
	    
	    int crediti=0;
	    int MAX=0;
	    int somma=0;
	    if (crediti >= numeroCrediti) {
	    	if (crediti == numeroCrediti) {
	    		if (M<= MAX) {
	    		M=MAX;
	    		return parziale;
	    		}
	    	}
	    	
	    }
	    
		for ( Esame e : lE) {
			if (e.getCrediti()+crediti< numeroCrediti) {
				crediti+=e.getCrediti();
				parziale.add(e);
				somma+=e.getVoto();
				
				calcolaSottoinsiemeEsami(numeroCrediti);
				
				parziale.remove(e);
				
			}
			
			
		}
		
		return null;
	}

}
