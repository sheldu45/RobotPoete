class Syllabe{
    
    private String reprPh;//representation phonétique
    
    public Syllabe(String reprPh){
	this.reprPh = reprPh;
    }

    public String reprPh(){return reprPh;}
    public void reprPh(String reprPh){this.reprPh = reprPh;}

    static int dist(Syllabe a, Syllabe b){
		return a.reprPh().equals(b.reprPh()) ? 0 : 1;
    }

}
