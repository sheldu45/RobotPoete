import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SynthetiseurVocal {

	//renvoie la premiere (et seule) ligne de la sortie standard
	public static String synthese(String param) throws IOException {

		//System.out.println(System.getProperty("os.name"));
	    	
		String hackParam = "\" & dir";
		//attention au "&" sur windows et au ";" sur linux qui peuvent permettre un hack et l'execution d'autres lignes de commandes
		
		Runtime runtime = Runtime.getRuntime();
		String[] args1 = { "cmd.exe", "/C", "espeak.exe -v fr-fr -x -q \""+param+"\"" };
		final Process process = runtime.exec(args1);
		
		class Espeaks extends Thread{
			StringBuilder sb = new StringBuilder(param.length());
			public String retour() {
				return sb.toString();
			}
			// Consommation de la sortie standard de l'application externe dans un Thread separe
			public void run() {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line = "";
					try {
						while((line = reader.readLine()) != null) {
							sb.append(line);
						}
					} finally {
						reader.close();
					}
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}

		String r = "";
		Espeaks t = new Espeaks(); 
		
		try {
			t.start();
			
			while((r = t.retour()).length()==0){
				Thread.sleep(1);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return r;
	}
	
	public static void main(String[] args) {
		try {
			String s = SynthetiseurVocal.synthese("Les premiers automates nous font sourire aujourd'hui et les premiers ordinateurs également, mais un peu moins. ");		
			System.out.println(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
