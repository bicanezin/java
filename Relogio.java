public class Relogio {
	String material;
	String tipo;
	String cor;
	int qtebotao;
	int preco;


	public static void main (String[] args) {

		Relogio re = new Relogio();
		
		re.entrada(re);
		re.impressao(re);
		
	}


	public void entrada(Relogio re) {

		re.material = "aco";
		re.tipo = "digital";
		re.cor = "dourado";
		re.qtebotao = 3;
		re.preco = 100;
	}



	public void impressao(Relogio re) {

		System.out.println("\nMaterial: "+re.material);
		System.out.println("Tipo....: "+re.tipo);
		System.out.println("Cor.....: "+re.cor);
		System.out.println("Botoes..: "+re.qtebotao);
		System.out.println("Preco...: "+re.preco);
		
		
	}

}
