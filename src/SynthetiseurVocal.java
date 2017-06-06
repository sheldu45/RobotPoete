import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SynthetiseurVocal {

	public static void main(String[] args) throws IOException {

		System.out.println(System.getProperty("os.name"));
	    	
		String param = "Bonjour et merci d'avoir été si nombreux à regarder mes vidéos !";
		String hackParam = "\" & dir";
		//attention au "&" sur windows et au ";" sur linux qui peuvent permettre un hack et l'execution d'autres lignes de commandes
		
		Runtime runtime = Runtime.getRuntime();
		String[] args1 = { "cmd.exe", "/C", "espeak.exe -v fr-fr -x -q \""+param+"\"" };
		final Process process = runtime.exec(args1);
		
		// Consommation de la sortie standard de l'application externe dans un Thread separe
		new Thread() {
			public void run() {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					String line = "";
					try {
						while((line = reader.readLine()) != null) {
							System.out.println(line);
						}
					} finally {
						reader.close();
					}
				} catch(IOException ioe) {
					ioe.printStackTrace();
				}
			}
		}.start();
	}

}