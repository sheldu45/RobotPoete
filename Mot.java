class Mot{
    
    private String mot;
    private CatGram cg;
    private Syllabe[] syllabes; 
    

    public Mot(String mot, CatGram cg, Syllabe[] syllabes){
		this.mot = mot;
		this.cg = cg; 
		this.syllabes = syllabes;	
    }
    

    public String getMot(){return this.mot;}
    public CatGram getCg(){return this.cg;}
    public Syllabe[] getSyllabes(){return this.syllabes;}

    public void mot(String mot){this.mot = mot;}
    public void cg(CatGram cg){this.cg = cg;}
    public void syllabes(Syllabe[] syllabes){this.syllabes = syllabes;}

}
