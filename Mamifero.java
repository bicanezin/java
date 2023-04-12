final public class Mamifero extends Animal implements Calculo{
	private String raça;
	private String habitat;
	private int idade;
	
	
	
	public int getRaça (){
		return raça;
	}
	
	public int getHabitat(){
		return habitat;
	}
	
	public int getIdade(){
		return idade;
	}
	
	public void setRaça(String raça){
		this.raça = raça;
	}
	
	public void setHabitat(String habitat){
			this.habitat =habitat;
	}
	
	public void setIdade(int idade){
			this.idade= idade;
	}
	
	public int calcVeloc (){
		return ((getVelocidade()*1000)/60);
	}

	
}