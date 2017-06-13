import java.util.ArrayList;

/**
 * implementation d'un tas min, par définition ordonné. Et
 * permet les méthodes de recherche par dichotomie (en temps ln(n))
 * @param <C> type des éléments contenus dans la liste
 */
public class Tas<C extends Comparable<C>>{

	//---------------Méthodes d'Instanciation---------------
	
	private ArrayList<C> contenu;   // Sous-arbre droit
    private int taille; 	// taille = nombre de nœuds
    
    // Constructeurs
    /** Consruit un tas à partir d'un tableau */
    public Tas(ArrayList<C> tableau){
		this.contenu = tableau;
		this.taille = tableau.size();
	}
	
	
	// Utiles 
	
	public String toString(){
		String res = "[";
        for (int i = 0; i < this.taille; i++){
            res = res + " " + this.contenu.get(i);
        }
        res = res + " ] size=" + this.taille;
        return res;
	}
	
		
	//-----------------Méthodes insertion et suppression d'éléments -----------------
	
	public boolean isEmpty(){
		return taille == 0;
	}
	
	public void echange(C elt1, C elt2){
		C tmp = elt1;
		elt1 = elt2;
		elt2 = tmp;
	}
	
	public int compare(int i, int j){
		int res = this.contenu.get(i).compareTo(this.contenu.get(j));
		return res ;
	}

	/** insertion d'un élément dans le tas
	 * 	Complexité en O(h) --> h étant la hauteur de l'arbre
	 * */
	public void ajout(C elt){
		if (isEmpty()){
			this.contenu.add(0,elt);
			this.taille++;
		}
		else{
			this.taille++;
			this.contenu.add(elt);
			int i = this.taille-1;
			int comp = compare(i,(i/2));
			while (i>1 && comp>0){
				echange(this.contenu.get(i),this.contenu.get(i/2));
				i = i/2;
			}
		}
	}
	
	/** suppression d'un élément
	 *  on suppose qu'on sait qu'il y est
	 *  Complexité en O(h) --> h étant la hauteur de l'arbre
	 *  */
	public void suppression(C elt){
		C a = this.contenu.get(0);
		this.contenu.set(1,this.contenu.get(taille));
		this.taille--;
		int i = 1;
		int filsmin;
		int comp2i = compare((2*i),i);
		int comp2i1 = compare((2*i+1),i);
		while ((2*i+1 <= this.taille) && (comp2i>0 || comp2i1 >0)){
			int newcomp = compare((2*i),(2*i+1));
			if (newcomp>0){
				filsmin = 2*i;
			}
			else{
				filsmin = 2*i+1;
			}
			echange(this.contenu.get(i),this.contenu.get(filsmin));
		}
		if ((2*i < this.taille) && (comp2i > 0)){
			echange(this.contenu.get(i),this.contenu.get(2*i));
		}
	}
	
	
	//----------------- Méthodes de tri par tas sur place -----------------
	
	public void tri(){
		for (int i = this.taille/2 ;i >=0;i--){
			System.out.println(this.contenu.get(i));
			this.entasse(i,this.taille);
		}
		for (int j = this.taille-1; j >= 1; j--){
			echange(this.contenu.get(1),this.contenu.get(j));
			this.entasse(1,j-1);
		}
	}
	
	public void entasse(int i, int t){
		int k = i;
		int j = 2*k;
		while(j < t){
			int comp = compare(k,j);
			if (comp < 0){
				echange(this.contenu.get(k),this.contenu.get(j));
				k = j;
				j = 2*k;
			}
			else{
				j = this.taille+1;
			}
		}
	}
	
		
		
	
	//----------------- Méthodes de recherche d'élément -----------------
	
	/**
     * cherche l'élement spécifié. 
     * En cas de succès et retourne l'indice. 
     * En cas d'échec il retourne -1
  	*/
	public int search(C elt){
		int res = -1;
		for (int i = 0; i < this.taille; i++){
			if (this.contenu.get(i) == elt){
				return i;
			}
		}
		return res;
	}
		
		

	//-----------------------Main-----------------------
  	
    public static void main(String[] args){
		/*ArrayList<String> al = new ArrayList<String>();
		Tas<String> t = new Tas<String>(al);
        t.ajout("<s>");
        t.ajout("de");
        t.ajout(".");     
        t.ajout(",");    
            
        System.out.println(t);
        t.tri(); 
        System.out.println(t); */
        
        ArrayList<Integer> al = new ArrayList<Integer>();
		Tas<Integer> t = new Tas<Integer>(al);
        t.ajout(1);
        t.ajout(2);
        t.ajout(4);     
        t.ajout(3);
        t.ajout(3); 
        t.ajout(8); 
        t.ajout(3); 
        t.ajout(2); 
        t.ajout(10);     
            
        System.out.println(t);
        t.tri(); 
        System.out.println(t);  
    }

}
