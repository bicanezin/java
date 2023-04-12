public class Filho{

	private int idf;
	private String nomef;
	private Pai pai = new Pai();
	

	final public void setIdf(int idf){
			this.idf = idf;
	}
	
	final public void setNomef(String nomef){
		this.nomef = nomef;
	}
	
	final public void setPai(Pai pai){
		this.pai=pai;
	}
	

	public int getIdf(){
		return idf;
	}

	public String getNomef(){
		return nomef;
	}
	
	public Pai getPai(){
		return pai;
	}
	
	
	
}