class Mot{

    //private CatGram 	cg;
    private String 		ecriture;
    private String 		prononciation;
    private String 		regExp;

    public Mot(String ecriture, String prononciation, String regExp){
		this.ecriture = ecriture;
		this.prononciation = prononciation; 
		this.regExp = regExp;	
    }

    public String getEcriture(){return this.ecriture;}
    public String getPrononciation(){return this.prononciation;}
    public String getRegExp(){return this.regExp;}
    //public CatGram getCg(){return this.cg;}
    //public Syllabe[] getSyllabes(){return this.syllabes;}

    public void setEcriture(String ecriture){this.ecriture = ecriture;}
    public void setPrononciation(String prononciation){this.prononciation = prononciation;}
    public void setRegExp(String regExp){this.regExp = regExp;}
    //public void cg(CatGram cg){this.cg = cg;}
    //public void syllabes(Syllabe[] syllabes){this.syllabes = syllabes;}

}
