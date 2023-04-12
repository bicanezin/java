package projects.projetoFinal_sinalgo.nodes.timers;

import projects.projetoFinal_sinalgo.nodes.messages.Mensagem;
import projects.projetoFinal_sinalgo.nodes.nodeImplementations.SinkNode;
import projects.projetoFinal_sinalgo.nodes.nodeImplementations.SensorNode;
import sinalgo.nodes.timers.Timer;

public class TimerMensagem extends Timer {
    private Mensagem message = null;

    public TimerMensagem(Mensagem message) {
        this.message = message;
    }

    @Override
    public void fire() {
	   try {
           ((SensorNode)node).sendDirect(message, ((SensorNode)node).getNoEstacaoBase());
       } catch (ClassCastException e) {
    	   ((SinkNode)node).broadcast(message);
       }
    }
}
