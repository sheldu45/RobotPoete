import java.io.File;

public class Dossier {

	private String path;
	
	public Dossier(String path){
		this.path = path;
	}
	
	public String getPath(){
		return this.path;
	}
	
	public void setPath(String path){
		this.path = path;
	}
	
	public String[] listFichiers(){
		File repertoire = new File(this.path);
		File[] fichiers = repertoire.listFiles();
		String[] retour = new String[fichiers.length];
		int i = 0;
		for(File f : fichiers){
			retour[i] = f.getName();
			i++;
		}
		return retour;
	}
	
	public static void main(String[] args){
		/*File directory = new File("./Categories");
		String path = directory.getAbsolutePath().toString();*/
		String path = Categorie.PATH;
		Dossier d = new Dossier(path);
		String[] s = d.listFichiers();
		for(String i : s){
			System.out.println(i);
		}
	}
	
}
