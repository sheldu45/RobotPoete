import java.util.regex.Pattern;

public class Voyelles{

    private String voy;
    

    public Voyelles(String v){
	this.voy = v;
    }

    public String getV(){
		return this.voy;
    }
    
    public void setV(String v){
		this.voy = v;
    }

    /** ----------- CALCUL DE LA DISTANCE ----------- 
     * On calcul la distance entre deux voyelles en fonction du 
	 * triangle vocalique, plus elles sont éloignées, plus la distance sera grande
	 * param : deux voyelles
	 * renvoie : float
     */
    
    /** Retourne 0 ou 1, 
     * 0 si les deux voyelles sont nasales ou orales
     * 1 si une des deux voyelles est nasale et l'autre orale
    */
    public static double nasales(Voyelles v1, Voyelles v2){
		String orales = "@aeiouyAEIOYW";
		String nasales = "1234";
			
		String est_nasale = "["+nasales+"]";
	 
		boolean nasalev1 = Pattern.matches(est_nasale,v1.voy);
		boolean nasalev2 =  Pattern.matches(est_nasale,v2.voy);
		
		double res = (nasalev1 == nasalev2)? 0.0:1.0;
		return res;
    }
    
     /** Retourne 0|0,25|0,5|0,75|1, 
     * 0 si les deux voyelles sont nasales ou orales
     * 0,25
     * 0,5
     * 0,75
     * 1 si une des deux voyelles est nasale et l'autre orale
    */
  public static double ouvertes(Voyelles v1, Voyelles v2){
		String fermee = "iyu";
		String semi_fermee = "eYo@";
		String semi_ouverte = "EWO";
		String ouverte  = "a"   ;
			
		String est_ouverte= "["+ouverte+"]";
		String est_semi_ouverte = "["+semi_ouverte+"]";
		String est_semi_fermee  = "["+semi_fermee+"]";
		String est_fermee = "["+fermee +"]";
		
		
	 
		boolean ouvertev1 = Pattern.matches(est_ouverte,v1.voy);
		boolean ouvertev2 =  Pattern.matches(est_ouverte,v2.voy);
		boolean semiouvertev1 = Pattern.matches(est_semi_ouverte,v1.voy);
		boolean semiouvertev2 =  Pattern.matches(est_semi_ouverte,v2.voy);
		boolean semifermeev1 = Pattern.matches(est_semi_fermee,v1.voy);
		boolean semifermeev2 =  Pattern.matches(est_semi_fermee,v2.voy);
		boolean fermeev1 = Pattern.matches(est_fermee,v1.voy);
		boolean fermeev2 =  Pattern.matches(est_fermee,v2.voy);
		
		// Premier cas : meme ouverture 
		if ((ouvertev1 == true && ouvertev2 == true) || (semiouvertev1 == true && semiouvertev2 == true) || (semifermeev1 == true && semifermeev2 == true) || (fermeev1 == true && fermeev2 == true)){
			return 0.0;
		}
		// Deuxième cas : si les deux sont similaires exemple : semiouverte et semi fermée ou semiouverte et ouverte
		else if ((ouvertev1 == true && semiouvertev2 == true) || (ouvertev2 == true && semiouvertev1 == true) || (semifermeev2 == true && semiouvertev1 == true) || (semifermeev1 == true && semiouvertev2 == true) || (semifermeev2 == true && fermeev1 == true) || (semifermeev1 == true && fermeev2 == true)){
			return 0.25;
		}
		// Troisième cas : semi ouverte et fermée ou semi fermée et ouverte
		else if ((fermeev1 == true && semiouvertev2 == true) || (fermeev2 == true && semiouvertev1 == true) || (semifermeev1 == true && ouvertev2 == true) || (semifermeev2 == true && ouvertev1 == true)){
			return 0.75;
		}
		// Quatrième cas : fermee et ouverte
		else if((fermeev1 == true && ouvertev2 == true) || (fermeev2 == true && ouvertev1 == true)){
			return 1.0;
		}
		return 2.0; // alors pb
    }
    
    public static void main(String[] args){
		String u = "1"; //nasale
		String d = "a"; // non nasale
		String t = "@"; // non nasale
		String q = "2"; // nasale
		Voyelles un = new Voyelles(u);
		Voyelles deux = new Voyelles(d);
		Voyelles trois = new Voyelles(t);
		Voyelles quatre = new Voyelles(q);
		
		// Tests Nasales
		System.out.println(nasales(un,deux));
		System.out.println(nasales(un,quatre));
		System.out.println();
		
		// Tests ouvertes
		System.out.println(ouvertes(un,deux));
		System.out.println(ouvertes(un,quatre));
		System.out.println(ouvertes(un,trois));
		System.out.println(ouvertes(deux,trois));
	}
		
}
    
