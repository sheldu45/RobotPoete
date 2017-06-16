import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class ChaineCategorielle extends LinkedList<String>{

		public final static String 	PATH = "./Categories/";
		public final static int 	MAX_CAPACITY = 1000;
		private String nom;
	    
	    public String getNom(){
	    	return this.nom;
	    }
	    
	    public void setNom(String nom){
	    	this.nom = nom;
	    }
	    // --------------- CONSTRUCTEURS ---------------
	/** Instancie une catégorie "nulle" */    
	public ChaineCategorielle(){
	    	super();
	    	this.nom = "";
	    }
	    
	/** Instancie la categorie à partir du nom du fichier contenant les lexemes */
	public ChaineCategorielle(String nom) throws IOException{
	    super();
		this.nom = nom;
		File fic = new File(PATH+nom);
		FileReader in = new FileReader(fic);
		BufferedReader br = new BufferedReader(in);
		String readLine = "";
            while ((readLine = br.readLine()) != null) {
		this.add(readLine);
	    }
		    in.close();
	    }
	    
	//  --------------- METHODES  ---------------
	
	/** Combine deux chaines catégorielles entre elles 
	renvoie une nouvelle chaine catégorielle */
	    static ChaineCategorielle combine(ChaineCategorielle c1, ChaineCategorielle c2){
	    	ChaineCategorielle c3 = new Categorie();
	    	c3.setNom(c1.nom + " " + c2.nom);
	    	for(String s1 : c1){
	    		for(String s2 : c2){
		    		c3.add(s1 + " " + s2);
		    	}
	    	}
	    	return c3;
	    }
	   
	/** */
	    public static Categorie generate(String chaineCategories){
	    	
	    }
	    
	    public String toString(){
	    	StringBuilder sb = new StringBuilder(this.size()*10);
	    	for(String s : this){
	    		sb.append(s+"\n");
	    	}
	    	return sb.toString();
	    }

		public static void main(String[] args){
			try {
				Categorie nom = new Categorie("nom_Commun");
				Categorie adjGauche = new Categorie("adjectif_Gauche");
				Categorie nomAdj = Categorie.combine(adjGauche, nom);
				System.out.println(nomAdj);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
