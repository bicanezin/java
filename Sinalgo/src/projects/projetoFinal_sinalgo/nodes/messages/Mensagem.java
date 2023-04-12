package projects.projetoFinal_sinalgo.nodes.messages;

import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Message;

public class Mensagem extends Message {
    public Node destino;
    public Node origem;
    public Node reencaminha;

    //0 para montagem de rotas e 1 para pacotes de dados
    public Integer tipoMsg = 0;
    public Integer mensagenID;
    public Integer tempoVidaPac;
    public Integer numSaltos;

    public Mensagem(Integer seqID, Node origem, Node destino, Node forwardingHop, Integer tipo) {
        this.mensagenID = seqID;
        this.origem = origem;
        this.destino = destino;
        this.reencaminha = forwardingHop;
        this.tipoMsg = tipo;
    }

    @Override
    public Message clone() {
        Mensagem msg = new Mensagem(this.mensagenID, this.origem, this.destino, this.reencaminha, this.tipoMsg);
        msg.tempoVidaPac = this.tempoVidaPac;
        msg.numSaltos = numSaltos;
        return msg;
    }
}
