import javax.swing.JOptionPane;

public class BDpes{
    private Pessoa[] vetPes = new Pessoa[5];

    public void insPes(Pessoa pessoa) throws RgException{
        for(int i = 0; i < vetPes.length; i++){
            if(vetPes[i] != null){
                if(consPesRg(pessoa) != null){
                    if(JOptionPane.showConfirmDialog(null, "Existe um registro com o mesmo RG. Deseja sobrepo-lo?", "Aviso", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                        vetPes[i] = new Pessoa();
                        try{
                            vetPes[i].setRg(pessoa.getRg());
                        } 
                        catch(RgException rge){ 
                            rge.exibeMsg();
                        }

                        vetPes[i].setNome(pessoa.getNome());
                        vetPes[i].getEndereco().setNumero(pessoa.getEndereco().getNumero());
                        vetPes[i].getEndereco().setRua(pessoa.getEndereco().getRua());

                        JOptionPane.showMessageDialog(null,"Pessoa inserida com sucesso");
                        return;
                    }
                    else{return;}
                }
            }
            else{
                vetPes[i] = new Pessoa();
                try{
                    vetPes[i].setRg(pessoa.getRg());
                } 
                catch(RgException rge){
                    rge.exibeMsg();
                }

                vetPes[i].setNome(pessoa.getNome());
                vetPes[i].getEndereco().setNumero(pessoa.getEndereco().getNumero());
                vetPes[i].getEndereco().setRua(pessoa.getEndereco().getRua());
    
                JOptionPane.showMessageDialog(null,"Pessoa inserida com sucesso");
                return;
            }
        }
        JOptionPane.showMessageDialog(null,"Espaco insuficiente para armazenar mais registros");
    }

    public Pessoa consPesRg(Pessoa pessoa){
        for(Pessoa pes: vetPes){
            if(pes != null){
                if(pes.getRg() == pessoa.getRg()){
                    return pes;
                }
            }
        }
        return null;
    }

    public Pessoa altPesRg(Pessoa pessoa){
        Pessoa flag = consPesRg(pessoa);
        return flag;
    }

    public void delPes(Pessoa pessoa){
        for (int i = 0; i < vetPes.length; i++){
            if (vetPes[i].getRg() == pessoa.getRg()){
                for (int j = i; j < vetPes.length; j++){
                    if(j == vetPes.length-1 || vetPes[j+1] == null){
                        vetPes[j] = null;
                        return;
                    }
                    else{
                        try{
                            vetPes[j].setRg(vetPes[j+1].getRg());
                        } 
                        catch (RgException rge) {}

                        vetPes[j].setNome(vetPes[j+1].getNome());
                        vetPes[j].getEndereco().setRua(vetPes[j+1].getEndereco().getRua());
                        vetPes[j].getEndereco().setNumero(vetPes[j+1].getEndereco().getNumero());
                    }
                }
            }
        }
    }
}