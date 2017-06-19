import java.util.regex.Pattern;

public class Voyelles{

    private char voy;
    

    public Voyelles(char v){
	this.voy = v;
    }

    public char getV(){
	return this.voy;
    }
    
    public void setV(char v){
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
    public static float nasales(Voyelles v1, Voyelles v2){
		String orales = "@aeiouyAEIOYW";
		String nasales = "1234";
			
		String est_nasale = "["+nasales+"]";
	 
		boolean nasalev1 = Pattern.matches(est_nasale,v1.getvoy());
		boolean nasalev2 =  Pattern.matches(est_nasale,v2.getvoy());
		
		float res = (nasalev1 == nasalev2)? 0.0:1.0;
		return res;
    }
    
     /** Retourne 0|0,25|0,5|0,75|1, 
     * 0 si les deux voyelles sont nasales ou orales
     * 0,25
     * 0,5
     * 0,75
     * 1 si une des deux voyelles est nasale et l'autre orale
    */
  /*  public static float ouverte(Voyelles v1, Voyelles v2){
		String ouverte = "iyu";
		String semi_ouverte = "eYo";
		String semi_fermee = "EWO";
		String fermee  = "a"   ;
			
		String est_ouverte= "["+ouverte+"]";
		String est_semi_ouverte = "["+semi_ouverte+"]";
		String est_semi_fermee  = "["+semi_fermee+"]";
		String est_fermee = "["+fermee +"]";
	 
		boolean ouvertev1 = Pattern.matches(est_ouverte,v1.getvoy());
		boolean nasalev2 =  Pattern.matches(est_nasale,v2.getvoy());
		
		float res = (nasalev1 == nasale v2)? 0:1;
		return res;
    }*/
    
