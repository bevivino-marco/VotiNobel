package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.dao.EsameDAO;

public class Model {
    EsameDAO dao = new EsameDAO();
    private List <Esame> parziale = new LinkedList <Esame >();
    private List <List <Esame>> lista = new LinkedList <List<Esame>>();
    
    private int crediti=0;
	private int MAX = 0;
    
	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
	    List <Esame> lE = new LinkedList <Esame >(dao.getTuttiEsami());
	    
	   
	    if (crediti== numeroCrediti) {
	    	setMax(parziale);
	    	lista.add(parziale);
	    	return parziale;
	    }
	    	
	    		
	    	
	    	
	    
	    
		for ( Esame e : lE) {
			if (crediti+e.getCrediti()<= numeroCrediti) {
				parziale.add(e);
				calcolaSottoinsiemeEsami(numeroCrediti);
				parziale.remove(e);
			}
			
			return null;
				
			
			
			
		}
		
		return null;
	}

	public void setMax (List <Esame>parziale) {
		int somma=0;
		for (Esame e : parziale) {
			somma+= e.getVoto();
		}
		if (somma>MAX) {
			MAX=somma;
		}
		
	}
	public List<List<Esame>> esamiMassimi (List <List <Esame>> l) {
		for (List <Esame> le : l) {
			int s = 0;
			for (Esame e :le) {
				s+= e.getVoto();
			}
			if (s<MAX) {
				l.remove(le);
			}
		}
		return l;
		
	}

	public List<List<Esame>> getLista() {
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
