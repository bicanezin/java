public class Porta{
    /*static*/String macTipo;
    /*static*/String material;
    /*static*/int preco;

    public static void main(String[] args) {
        Porta p = new Porta(); //metodo construtor -- aloca o objeto na memoria e passa ao SO as dimensoes de "p"
                              // p "puxa" todas as variaveis globais declaradas e tbm os metodos da classe
                              // declara��o = instancia��o

                              // OBJETO � UMA INSTANCIA DE UMA CLASSE -- carrega do HD, passa pelo processador e vai para mem RAM
                              // OBJETO � um apontamento para um endere�o de mem�ria

        p.macTipo = "Colonial"; // "para onde o P aporta, acesse o atributo macTipo, no qual, � Colonial"
        p.material = "Madeira";
        p.preco = 23;

        p.impPorta(p);

        System.out.println("\nVoltei pro main\n");
        /*System.out.println("\nTipo mac..: "+p.macTipo);
        System.out.println("Material..: "+p.material);
        System.out.println("Preco.....: "+p.preco);*/

        // O GARBAGE COLLECTOR LIMPA DA MEM�RIA OS OBJETOS QUE PERDERAM SUAS REFERENCIAS
    }

    public void impPorta(Porta k){
        Porta l = new Porta();
        l = k;
        System.out.println("\nIMPRESS�O IMPPORTA\n");
        System.out.println("Tipo mac..: "+l.macTipo);
        System.out.println("Material..: "+l.material);
        System.out.println("Preco.....: "+l.preco);
    }
}
