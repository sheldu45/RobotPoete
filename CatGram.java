public enum CatGram {

    PRONOM("pro"),
    VERBE("V"),
    NOM("N"),
    DET("det"),
    ADJG("adjg"),
    ADJD("adjd");

    private String repr;
    
    private CatGram(String repr){ // Apparement dans les enum ton constrcteur ne doit pas etre public
		this. repr = repr; 
    }
    
    public String repr(){return this.repr;}
    public void repr(String repr){this.repr = repr;}
}
