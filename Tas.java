/**
 * implementation d'un tas min, par définition ordonné. Et
 * permet les méthodes de recherche par dichotomie (en temps ln(n))
 * @param <C> type des éléments contenus dans la liste
 */
public class Tas<E extends Comparable<E>>{

	//---------------Méthodes d'Instanciation---------------
	
    private int taille; 	// taille = nombre de nœuds
    private E label;                // étiquette du noeud de l'arbre
    private BinaryTree<E> left;     // Sous-arbre gauche
    private BinaryTree<E> right;    // Sous-arbre droit
    
    // Constructeurs
    /** Consruit une feuille d'étiquette label. */
    public BinaryTree(E label){
        this(label, null, null);
    }
    
        /** Consruit un arbre d'étiquette label avec 2 sous arbres. */
    public BinaryTree(E label, BinaryTree<E> left, BinaryTree<E> right){
        this.label = label;
        this.left = left;
        this.right = right;
    }
	
	
	// Utiles 
	
	public String toString(){
		String res = "[";
        for (int i = 0; i < this.taille; i++){
            res = res + " " + this.contenu[i];
        }
        res = res + " ] size=" + this.taille;
        return res;
	}
	
	    /** Renvoie true ssi ce noeud est une feuille. */
    public boolean isLeaf(){
        return left == null && right == null;
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

	/** insertion d'un élément dans le tas
	 * 	Complexité en O(h) --> h étant la hauteur de l'arbre
	 * */
	public void add(C elt){
		if (isEmpty()){
			this.contenu[0] = elt;
			this.taille++;
		}
		else{
			this.taille++;
			this.contenu[taille] = elt;
			int i = this.taille;
			int comp = this.contenu[i].compareTo(this.contenu[i/2]);
			while (i>1 && comp>0){
				echange(this.contenu[i],this.contenu[i/2]);
			}
		}
	}
	
	/** suppression d'un élément
	 *  on suppose qu'on sait qu'il y est
	 *  Complexité en O(h) --> h étant la hauteur de l'arbre
	 *  */
	public void suppression(C elt){
		C a = this.contenu[0];
		this.contenu[1] = this.contenu[taille];
		this.taille--;
		int i = 1;
		int filsmin;
		int comp2i = this.contenu[2*i].compareTo(this.contenu[i]);
		int comp2i1 = this.contenu[2*i+1].compareTo(this.contenu[i]);
		while ((2*i+1 <= this.taille) && (comp2i>0 || comp2i1 >0)){
			int newcomp = this.contenu[2*i].compareTo(this.contenu[2*i+1]);
			if (newcomp>0){
				filsmin = 2*i;
			}
			else{
				filsmin = 2*i+1;
			}
			echange(this.contenu[i],this.contenu[filsmin]);
		}
		if ((2*i < this.taille) && (comp2i > 0)){
			echange(this.contenu[i],this.contenu[2*i]);
		}
	}
	
	
	//----------------- Méthodes de tri par tas sur place -----------------
	
	public void tri(){
		for (int i = 1;i <this.taille;i++){
			entasse(this.contenu,i);
		}
		for (int j = this.taille; j > 1; j++){
			echange(this.contenu[1],this.contenu[j]);
			reEntasse(this.contenu,j);
		}
	}
	
	public void entasse(C[] tab, int i){
		int j = i;
		int compj2 = this.contenu[j].compareTo(this.contenu[j/2]);
		while ((j != 1) && ( compj2 < 0)){
			echange(this.contenu[j], this.contenu[j/2]);
			j = j/2;
		}
	}
	
	public void reEntasse(C[] tab, int i){
		int j = 1;
		int filsmax;
		int comp2j = this.contenu[j].compareTo(this.contenu[2*j]); 
		int comp2j1 = this.contenu[j].compareTo(this.contenu[2*j+1]);
		while ((2*j+1) <= i && ( comp2j > 0 || comp2j1 > 0 )){
			int newcomp = this.contenu[2*j].compareTo(this.contenu[2*j+1]);
			if (newcomp>0){
				filsmax = 2*j;
			}
			else{
				filsmax = 2*j+1;
			}
			j = filsmax;
		}
		if ((2*j < i) && (comp2j<0)){
			echange(this.contenu[j],this.contenu[2*j]);
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
			if (this.contenu[i] == elt){
				return i;
			}
		}
		return res;
	}
		
		

	//-----------------------Main-----------------------
  	
    public static void main(String[] args){
		String[] tab = new String[0];
		Tas<String> t = new Tas<String>(tab);

        t.add("<s>");  
        t.add(".");    
        t.add(",");    
        t.add("de");    
        System.out.println(t);   
    }

}
