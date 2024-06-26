
/**
 * A classe VisorDeRelogio implementa um visor de relógio digital.
 * O relógio mostra horas e minutos. O relógio marca de 00:00 (meia-noite)
 * até 23:59 (um minuto para meia-noite).
 * 
 * O visor do relógio recebe "tique-taques" (através do método tiqueTaque) a
 * cada minuto e reage incrementado o valor do visor. Isso é feito como é em
 * um relógio, a hora incrementa quando os minutos voltam para zero.
 * 
 * Traduzido por Julio César Alves - 2023.09.15
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class VisorDeRelogio
{
    private VisorDeNumero horas;
    private VisorDeNumero minutos;
    private String stringVisor;    // simula o visor real
    
    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando 00:00.
     */
    public VisorDeRelogio()
    {
        horas = new VisorDeNumero(13);
        minutos = new VisorDeNumero(60);
        atualizarVisor();
    }

    /**
     * Construtor para objetos VisorDeRelogio. Este construtor
     * cria um novo relógio marcando as horas de acordo com 
     * os parâmetros recebidos.
     */
    public VisorDeRelogio(int hora, int minuto)
    {
        horas = new VisorDeNumero(13);
        minutos = new VisorDeNumero(60);
        definirHora(hora, minuto);
    }

    /**
     * Este método deveria ser chamado uma vez a cada minuto -
     * ele faz o visor do relógio passar um minuto.
     */
    public void tiqueTaque()
    {
        minutos.incrementar();
        if(minutos.obterValor() == 0) {  // minutos voltaram para zero
            horas.incrementar();
        }
        if (horas.obterValor() == 0) // horas volta para 1
        {
            horas.definirValor(1);
        }
        atualizarVisor();
    }

    /**
     * Define a hora do visor de acordo com o valor de hora e
     * minuto recebidos por parâmetro.
     */
    public void definirHora(int hora, int minuto)
    {
        if (hora != 0) 
        {
            horas.definirValor(hora);
        }
        minutos.definirValor(minuto);
        atualizarVisor();
    }

    /**
     * Retorna a hora atual do visor no formato HH:MM.
     */
    public String obterHora()
    {
        return stringVisor;
    }
    
    /**
     * Atualiza a string interna que representa o visor.
     */
    private void atualizarVisor()
    {
        
        stringVisor = horas.obterValorVisor() + ":" + 
                        minutos.obterValorVisor();
    }
}
