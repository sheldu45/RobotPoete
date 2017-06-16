/** Classe AVL, fichier AVL.java
    Créer un objet AVL 
    ajoute des éléments comparables à l'intérieur
    recherche rapidement grâce à la structure ces éléments
    */

public class AVL<E extends Comparable<E>>{
	
    private E label;                // étiquette du noeud de l'arbre
    private AVL<E> left;     // Sous-arbre gauche
    private AVL<E> right;    // Sous-arbre droit
    private int height;
    
    // Constructeurs
    /** Consruit une feuille d'étiquette label. */
    public AVL(E label){
        this(label, null, null,0);
    }
    
    /** Consruit un arbre d'étiquette label avec 2 sous arbres. */
    public AVL(E label, AVL<E> left, AVL<E> right, int height ){
        this.label = label;
        this.left = left;
        this.right = right;
        this.height = height;
    }
    /** Renvoie True si l'arbre est vide, False sinon */
    public boolean isEmpty(){
		return left == null && right == null;
	}
	
	/* Renvoie la hauteur de l'arbre */
	 public int hauteur() {
         return this.isEmpty()== true ? -1 : this.hauteur();
     }
    
     // ----------------------- INSERTION -----------------------
	/** Ajout d'un élément 
	    paramètre : élément E
	    Complexité : O(log n)
	    */
	public AVL<E> insertion(E elt){
		 int comp = elt.compareTo(this.label);
		 AVL<E> t = null;
         if (this.isEmpty() == true){
             t = new AVL<E>(elt);
		 }
         else if (comp < 0){
             this.left = this.left.insertion(elt);
             if(this.left.hauteur() - this.right.hauteur() == 2){
				 int comp2 = elt.compareTo(this.left.label);
                 if(comp2 < 0){
					 t = this.rotGauche();
				 }
                 else{
                     t = this.doublerotGauche();
				 }
         }
         else if(comp > 0){
             this.right = this.right.insertion(elt);
             if(this.right.hauteur() - this.left.hauteur() == 2){
				 int comp2 = elt.compareTo(this.right.label);
                 if( comp2 < 0){
                     t = this.rotDroite();
				 }
                 else{
                     t = this.doublerotDroite();
				 }
			}
         }
         this.height = Math.max(this.left.hauteur(), this.right.hauteur()) + 1;
         return t;
        }
		return t;
     }
     
     // ----------------------- ROTATIONS -----------------------
     public AVL<E> rotGauche(){
         AVL<E> gauche = this.left;
         this.left = gauche.right;
         gauche.right = this;
         this.height = Math.max(this.left.hauteur(), this.right.hauteur()) + 1;
         gauche.height = Math.max(gauche.left.hauteur(),this.hauteur()) + 1;
         return gauche;
     }
     
     public AVL rotDroite(){ 
         AVL droit = this.right;
         this.right = droit.left;
         droit.left = this;
         this.height = Math.max(this.left.hauteur(), this.right.hauteur()) + 1;
         droit.height = Math.max(droit.right.hauteur(), this.hauteur()) + 1;
         return droit;
     }
     
     public AVL doublerotGauche(){ 
         this.left = this.left.rotDroite();
         return this.rotGauche();
     }
     
     public AVL doublerotDroite(){// k1 = this
         this.right = this.right.rotGauche();
         return this.rotDroite();
     } 
     
     
     // ----------------------- RECHERCHE ----------------------- 
     
     public boolean recherche(E elt){ // this == r, val = elt
         while (this.isEmpty() == false){
             E bfr = this.label;
             int comp = elt.compareTo(bfr);
             if (comp < 0){
                return this.left.recherche(elt);
			 }
             else if (comp > 0){
                return this.left.recherche(elt);
             } 
             else{
            	 return true;
             }
         }
         return false;
     }
}
