/** Classe AVL, fichier AVL.java
    Créer un objet AVL 
    ajoute des éléments comparables à l'intérieur
    recherche rapidement grâce à la structure ces éléments
    */

public class AVL<E extends Comparable<E>>{
	
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
    /** Renvoie True si l'arbre est vide, False sinon */
    public boolean isEmpty(){
		return left == null && right == null;
	}
	
	/** Compare deux éléments avec la fonction compareTo() */
	public int compare(E i, E j){
		int res = this.contenu.get(i).compareTo(this.contenu.get(j));
		return res ;
	}
	
	/* Renvoie la hauteur de l'arbre */
	 public int hauteur() {
         return this.isEmpty()== true ? -1 : this.hauteur;
     }
    
     // ----------------------- INSERTION -----------------------
     public AVL insertion(E elt){
         if (this.isEmpty() == true){
             t = new AVL(x);
		 }
		 int comp = compare(elt,this.label);
         else if (comp < 0){
             this.left = this.left.insertion(elt);
             if(this.left.hauteur - this.right.hauteur() == 2){
				 int comp2 = compare(elt,this.left.label);
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
				 int comp2 = compare(elt,this.right.label);
                 if( comp2 < 0)(
                     t = this.rotDroite();
				 }
                 else{
                     t = this.doublerotDroite();
				 }
			}
         }
         this.hauteur = max(this.left.hauteur(), this.right.hauteur()) + 1;
         return t;
     }
     
     // ----------------------- ROTATIONS -----------------------
     public AVL rotGauche(){
         AVL gauche = this.left;
         this.left = gauche.right;
         gauche.right = this;
         this.height = max(this.left.hauteur(), this.right.hauteur()) + 1;
         gauche.height = max(gauche.left.hauteur(),this.hauteur()) + 1;
         return k1;
     }
     
     public AVL rotDroite(){ 
         AVL droit = this.right;
         this.right = droit.left;
         droit.left = this;
         this.hauteur = max(this.left.hauteur(), this.right.hauteur()) + 1;
         droit.hauteur = max(droite.rigtht.hauteur(), this.hauteur()) + 1;
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
         boolean trouve = false;
         while (!trouve && (this.isEmpty() == false)){
             E bfr = this.label;
             int comp = compare(elt,bfr);
             if (comp < 0){
                 this = this.left;
			 }
             else if (comp > 0){
                 this = this.right;
             } 
             else if (comp == 0){
                 found = true;
                 break;
             }
             found = this.recherche(elt);
         }
         return found;
     }
