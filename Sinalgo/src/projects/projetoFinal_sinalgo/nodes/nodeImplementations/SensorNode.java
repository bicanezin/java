package projects.projetoFinal_sinalgo.nodes.nodeImplementations;

import java.awt.Color;

import projects.projetoFinal_sinalgo.nodes.messages.Mensagem;
import projects.projetoFinal_sinalgo.nodes.timers.TimerMensagem;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.Tools;

public class SensorNode extends Node {
  // no utilizado ate chegar na estacao base
  private Node noEstacaoBase;
  private Node noRecebido = null;

  private Integer sequencia = 0;

  @Override
  public void manipulaMensagens(Inbox inbox) {
    while (inbox.hasNext()) {
      Message msg = inbox.next();

      if (msg instanceof Mensagem) {
        Boolean encaminhar = Boolean.TRUE;
        Mensagem mensagem = (Mensagem) msg;

        // descarta mensagem que voltou
        if (mensagem.reencaminha.equals(this))
          encaminhar = Boolean.FALSE;

        // atualiza rota
        else if (mensagem.tipoMsg == 0) {
          this.setColor(new Color(0, 255, 0));
          if (noEstacaoBase == null) {
            noRecebido = mensagem.origem;

            System.out.println(this.ID + " recebe pacote do Sink " + mensagem.origem.ID);
            Tools.appendToOutput(this.ID + " recebe pacote do Sink " + mensagem.origem.ID + "\n");

            noEstacaoBase = inbox.getSender();
            sequencia = mensagem.mensagenID;
          }

          else if (sequencia < mensagem.mensagenID)
            sequencia = mensagem.mensagenID;
          else
            encaminhar = Boolean.FALSE;
        } 
        
        else if (mensagem.tipoMsg == 1) {
          mensagem.reencaminha = this;
          System.out.println(this.ID + " envia para " + this.noEstacaoBase.ID);
          Tools.appendToOutput(this.ID + " envia para " + this.noEstacaoBase.ID + "\n");
          sendDirect(msg, noEstacaoBase);
          encaminhar = Boolean.FALSE;
        }

        // armazena no que vai encaminhar a mensagem
        if (encaminhar) {
          this.setColor(new Color(0, 255, 0));
          mensagem.reencaminha = this;
          broadcast(mensagem);
        }
      }
    }
  }

  public Node getNoEstacaoBase() {
    return this.noEstacaoBase;
  }

  @Override
  public void preStep() {
    if (noEstacaoBase != null) {
      Mensagem mensagem = new Mensagem(sequencia + 1, this, null, this, 1);
      TimerMensagem temporizador = new TimerMensagem(mensagem);
      temporizador.startRelative(sequencia + 1, this);
    }
  }

  @Override
  public void postStep() {
    int i = 0;
    i += 1;
    if (i >= 400 && noRecebido != null) {
      Mensagem mensagem = new Mensagem(sequencia + 1, this, noRecebido, this, 1);
      send(mensagem, noRecebido);
      i = 0;
    }
  }

  @Override
  public void init() {}

  @Override
  public void neighborhoodChange() {}

  @Override
  public void checkRequirements() throws WrongConfigurationException {}
}
