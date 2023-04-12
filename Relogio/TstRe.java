public class TstRe {
    public static void main (String arg[]) {

        //Relogio re = new Relogio(); // relogio se comportando como relogio (Relogio()) // não posso instanciar pq é uma classe abstrata
        Mostrador m = new Mostrador();
        Pulso p = new Pulso(); // um objeto do tipo p é tudo oq tem na classe pulso + tudo oq herdou da classe relogio
        //Relogio misto = new Pulso(); // relogio se comportando como relogio de pulso, assim eu acesso o método na classe filha pela classe mãe, então a classe mãe pode pegar os da classe filha (herança reversa kkkkkk)
        
        
        p.setModelo("Feminino");      
        p.setMarca("Dourado");
        p.setQteBotoes(3);
        p.setPreco(100);
        p.getMaterial().setTipoMat("Aco");
        p.getMaterial().setOrig("Sul");
        p.getMaterial().setCodOrig(02);
        p.getMaterial().getPais().setNome("Peru");
        p.getMaterial().getPais().setCodPais(05);
        m.setMostrador("Digital");
        m.getHorario().setHora(18);
        m.getHorario().setMinuto(40);
        m.getHorario().getData().setDia(13);
        m.getHorario().getData().setMes(05);

        p.setCorPuls("Marron"); // pertence a classe pulso
        p.setMatPuls("Couro");
        p.setCompPuls(23);
        p.setLargPuls(25);
        p.setPreco(150); // pertence classe relogio, e ja que pulso herda tudo de classe porta p pode acessar
        p.setModelo("Feminino");
        p.setMarca("Casio");
        p.setQteBotoes(4);
        p.getMaterial().setTipoMat("Aco"); //orig pertence a material que está na classe relogio, ja que ele está na classe porta posso acessar com o p pq pulso é um tipo de relogio

        
        
        System.out.println("\n--------- INFORMACOES DO RELOGIO 1 ----------");
        System.out.println("\nModelo.....................: "+p.getModelo());
        System.out.println("Marca......................: "+p.getMarca());
        System.out.println("Mostrador..................: "+m.getMostrador());
        System.out.println("Horario no visor agora.....: "+m.getHorario().getHora()+":"+m.getHorario().getMinuto());
        System.out.println("Data no visor agora........: "+m.getHorario().getData().getDia()+"/"+m.getHorario().getData().getMes());
        System.out.println("Quantidade de botoes.......: "+p.getQteBotoes());
        System.out.println("Tipo de material...........: "+p.getMaterial().getTipoMat());
        System.out.println("Origem do Material.........: "+p.getMaterial().getOrig());
        System.out.println("Pais de origem do material.: "+p.getMaterial().getPais().getNome());
        System.out.println("Preco......................: "+p.getPreco());
        System.out.println("Codigo origem do Material..: "+p.getMaterial().getCodOrig());
        System.out.println("Codigo do pais de origem...: "+p.getMaterial().getPais().getCodPais()+"\n");

        System.out.println("\n------- INFORMACOES RELOGIO DE PULSO --------");
        System.out.println("\nModelo.....................: "+p.getModelo());
        System.out.println("Marca......................: "+p.getMarca());
        System.out.println("Material do relogio........: "+p.getMaterial().getTipoMat());
        System.out.println("Quantidade de botoes.......: "+p.getQteBotoes());
        System.out.println("Cor pulseira...............: "+p.getCorPuls());
        System.out.println("Material da pulseira.......: "+p.getMatPuls());
        System.out.println("Comprimento da pulseira....: "+p.getCompPuls()+"cm");
        System.out.println("Largura da pulseira........: "+p.getLargPuls()+"mm");
        System.out.println("Preco do relogio de pulso..: "+p.getPreco());

        p.teste();
    }
}