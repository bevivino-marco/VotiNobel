package it.polito.tdp.model;

import java.util.*;

import it.polito.tdp.dao.EsameDAO;

public class Model {
	
    
    private int L;
    private List <Esame> esami;
     
    private Set <Esame> best;
    private double media_best;
    public Model () {
		EsameDAO dao = new EsameDAO();
		this.esami= dao.getTuttiEsami();
	}
    
	public Set<Esame> calcolaSottoinsiemeEsami(int numeroCrediti) {
		
		Set <Esame> parziale = new HashSet<>();
		best = null;
		
		media_best=0.0;
		cerca(parziale, 0, numeroCrediti);
		return best;
	    
	   
	    
	}

	
	
	
	public void cerca (Set <Esame> parziale, int L, int credMax ) {
		// terminale
		if (getC(parziale)==credMax) {
			double media;
			media = calcolaMedia(parziale);
			if( media> media_best){
				best = new HashSet <Esame>(parziale);
				media_best =media;
				return;
			}else return;
			
		}if (L == esami.size())
			return;
		
		
		//normale
		// non aggiungo
		/*cerca (parziale, L+1, credMax);
		
		//lo aggiungo
		parziale.add(esami.get(L));
		cerca (parziale, L+1, credMax);
		parziale.remove(esami.get(L));*/
		for (Esame e : esami) {
			
			if ((getC(parziale)+e.getCrediti())<=credMax && !parziale.contains(e))
			{
			parziale.add(e);
			cerca (parziale, L+1, credMax);
			parziale.remove(e);
			
			}
			
		}
		//se inserisco un numero di crediti superiore a 64 (circa) il programma va in loop
		// o, più probabile, ci mette troppo tempo ad elaborare , posso renderlo piu veloce
		// tenendo il ciclo for, se è possibile.
		
	}
	
	private double calcolaMedia(Set<Esame> parziale) {
		int voto;
		double media =0.0;
		int somma=0;
		int crediti = 0;
		for (Esame e : parziale) {
			voto = e.getVoto();
			crediti+=e.getCrediti();
			somma+=voto*e.getCrediti();
		}
		
		return somma/crediti;
	}




	public int getC (Set <Esame> parziale) {
		int somma=0;
		for (Esame e: parziale) {
			somma+= e.getCrediti();
		}
		return somma;
	}
	
	
	
	
}
