package projects.projetoFinal_sinalgo.nodes.nodeImplementations;

import java.awt.Color;

import projects.projetoFinal_sinalgo.nodes.messages.Mensagem;
import projects.projetoFinal_sinalgo.nodes.timers.TimerMensagem;
import sinalgo.configuration.WrongConfigurationException;
import sinalgo.nodes.Node;
import sinalgo.nodes.messages.Inbox;
import sinalgo.nodes.messages.Message;
import sinalgo.tools.Tools;

public class SinkNode extends Node {
  @Override
  public void manipulaMensagens(Inbox inbox) {
    while (inbox.hasNext()) {
      Message msg = inbox.next();

      if (msg instanceof Mensagem) {
        Mensagem mensagem = (Mensagem) msg;

        if (mensagem.tipoMsg == 1) {
          this.setColor(new Color(0, 0, 255));
          System.out.println("Sink " + this.ID + " recebe pacote do " + mensagem.origem.ID);
          Tools.appendToOutput("Sink " + this.ID + " recebe pacote do " + mensagem.origem.ID + "\n");
        }
      }
    }
  }

  @NodePopupMethod(menuText = "Montar arvore de roteamento")
  public void construirRoteamento() {
    System.out.println("O Sink " + this.ID + " enviara pacotes para toda sua rede");
    Tools.appendToOutput("O Sink " + this.ID + " enviara pacotes para toda sua rede\n");
    Mensagem mensagem = new Mensagem(1, this, null, this, 0);
    TimerMensagem timer = new TimerMensagem(mensagem);
    timer.startRelative(1, this);
  }

  @Override
  public void preStep() {}

  @Override
  public void postStep() {}

  @Override
  public void init() {}

  @Override
  public void neighborhoodChange() {}

  @Override
  public void checkRequirements() throws WrongConfigurationException {}
}
