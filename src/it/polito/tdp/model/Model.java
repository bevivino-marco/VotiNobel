package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.dao.EsameDAO;

public class Model {
    EsameDAO dao = new EsameDAO();
    private List <Esame> parziale = new LinkedList <Esame >();
    private List <List <Esame>> lista = new LinkedList <List<Esame>>();
    private List <Esame> lE = new LinkedList <Esame >(dao.getTuttiEsami());
    
    private int crediti=0;
	private int MAX = 0;
	
    
	public List<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
	    
	   
	    if (crediti== numeroCrediti) {
	    	lista.add(parziale);
	    	return parziale;
	    }
	    	
	    		
	    	
	    	
	    
	    
		for ( Esame e : lE) {
			if (crediti+e.getCrediti()<= numeroCrediti && !parziale.contains(e)) {
				parziale.add(e);
				crediti+=e.getCrediti();
				calcolaSottoinsiemeEsami(numeroCrediti);
				parziale.remove(e);
				crediti-=e.getCrediti();
			}
			
			
				
			
			
			
		}
		
		return parziale;
	}

	public void setMax (List <Esame>parziale) {
		int somma=0;
		int m =0;
		for (Esame e : parziale) {
			somma+= e.getVoto();
		}
		m = somma/(parziale.size());
		if (m>MAX) {
			MAX=m;
		}
		
	}
	public List<List<Esame>> esamiMassimi (List <List <Esame>> l) {
		for (List <Esame> le : l) {
			int s = 0;
			for (Esame e :le) {
				s+= e.getVoto();
			}
			if ((s/(le.size()))<MAX) {
				l.remove(le);
			}
		}
		return l;
		
	}

	public List<List<Esame>> getLista() {
		return lista;
	}

	public List<Esame> getEsami() {
		// TODO Auto-generated method stub
		return dao.getTuttiEsami();
	}
	
	/*public void addL (List<Esame> parziale) {
		lista.add(parziale);
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
