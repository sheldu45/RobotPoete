import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Syllabeur {
	
	public static String syllabeur(String str) {
		str = str.replaceAll("[!', \\-\\_\\;]", "");
		str = str.replaceAll("z2", "z"); //espeaks note ainsi les liaisons
		str = str.replaceAll("A~", "1");
		str = str.replaceAll("E~", "2");
		str = str.replaceAll("O~", "3");
		str = str.replaceAll("W~", "4");
		str = str.replaceAll("yi", "5i");

		StringBuilder sb = new StringBuilder(str.length()*2);
		sb.append(str);
		
		String classeConsonne = "bpmtdnfvszSZkgrl";
		String classeGlide = "wj5";
		String voyelles = "@aeiouyAEIOYW1234";
		
		String regExConsonne = "["+classeConsonne+"]";
		String regExGlide = "["+classeGlide+"]";
		String regExGlideConsonne = "["+classeConsonne+classeGlide+"]";
		String regExNonVoyelle = "["+classeConsonne+classeGlide+'|'+"]";
		String regExAgglutinnante = "[rl"+classeGlide+"]";
		String regExVoyelle = "["+voyelles+"]";
		
		int i = 0;
		while(i<sb.length()){
			int length = sb.length();
			char charAct = sb.charAt(i);			
			
			int t = 1;
			
			//cas consonnantique
			boolean consonne = Pattern.matches(regExGlideConsonne, sb.charAt(i)+""); 
			if(consonne){
				//cas biconsonnantique
				if(i<length-2 && Pattern.matches(regExGlideConsonne, sb.charAt(i)+"") && Pattern.matches(regExGlideConsonne, sb.charAt(i+1)+"")){
					//cas triconsonnantique
					if(i<length-3 && Pattern.matches(regExGlideConsonne, sb.charAt(i+2)+"")){
						//cas quadriconsonnantique
						if(i<length-3 && Pattern.matches(regExGlideConsonne, sb.charAt(i+3)+"")){
							sb.insert(i+2, '|');
							t += 4;
							//de plus si la 4-eme lettre n'est pas agglutinante on ajoute un sc
							if(!Pattern.matches(regExAgglutinnante, sb.charAt(i+3+1)+"")){
								sb.insert(i+3+1, '@');
							}
						}					
						//cas triconsonnantique pur
						else{
							sb.insert(i+1, '|');
							t += 3;
							//de plus si la 3-eme lettre n'est pas agglutinante on ajoute un sc
							if(!Pattern.matches(regExAgglutinnante, sb.charAt(i+2+1)+"")){
								sb.insert(i+2+1, '@');
							}
						}
					}
					//cas biconsonnantique pur
					else{
						//la seconde consonne est une glide
						if(Pattern.matches(regExGlide, sb.charAt(i+1)+"")){
							sb.insert(i, '|');
						}
						//la seconde consonne est agglutinante
						else if(Pattern.matches(regExAgglutinnante, sb.charAt(i+1)+"")){
							//la premiere consonne est agglutinante aussi
							boolean a = Pattern.matches(regExAgglutinnante, sb.charAt(i)+"");
							if(a)	sb.insert(i+1, '|');
							//seulement la deuxieme
							else{
								//mais la premiere est soit un "m" soit un "n" (on ne s'y agglutine pas)
								if(sb.charAt(i) == 'm' || sb.charAt(i) == 'n'){
									sb.insert(i+1, '|');
								}
								else{
									sb.insert(i, '|');
								}
							}
						}
						else{
							sb.insert(i+1, '|');
						}
						t += 2;
					}
				}
				else{

				}
			}
			//cas Voyelle
			else if(Pattern.matches(regExVoyelle, sb.charAt(i)+"")){
				//la lettre suivante est une voyelle
				if(i<length-2 && Pattern.matches(regExVoyelle, sb.charAt(i+1)+"")){
					sb.insert(i+1, '|');
					t+=2;
				}
				/*
				//il s'agit d'un 'e' (=> syllabe ouverte)
				else if (sb.charAt(i) == 'e'){
					sb.insert(i+1, '|');
					t+=1;
				}
				//il s'agit d'un 'O' (=> syllabe fermée) et la lettre suivante est une consonne
				else if (sb.charAt(i) == 'O' && i<length-2 && Pattern.matches(regExGlideConsonne, sb.charAt(i+1)+"")){
					sb.insert(i+2, '|');
					t+=3;
				}
				*/
				//la lettre precedente existe et est une consonne
				if(i>0 && Pattern.matches(regExGlideConsonne, sb.charAt(i-1)+"")){
					//et celle qui le précède encore existe aussi et n'est ni une consonne ni le '|'
					if(i>1 && !Pattern.matches(regExNonVoyelle, sb.charAt(i-2)+"")){
						sb.insert(i-1, '|');
						t+=1;
					}
				}
				else{
					sb.insert(i, '|');
					t+=1;
				}
			}
			else{
				t++;
			}
			i+=t;
		}
		
	str = sb.toString();
	str = str.replaceAll("1", "A~");
	str = str.replaceAll("2", "E~");
	str = str.replaceAll("3", "O~");
	str = str.replaceAll("4", "W~");
	str = str.replaceAll("5", "y");
		
	return str;
	}
	
	public static void main(String[] args) {
		try {
			String s = SynthetiseurVocal.synthese("Les premiers automates nous font sourire aujourd'hui. Les premiers ordinateurs également, mais un peu moins. ");		
			System.out.println(s);
			
			String s2 = Syllabeur.syllabeur(s);

			System.out.println(s2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
