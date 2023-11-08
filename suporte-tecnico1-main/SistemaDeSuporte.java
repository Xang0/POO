/**
 * Esta classe implementa um sistema de suporte técnico. Ela é a classe de
 * nível mais alto neste projeto. O sistema de suporte se comunica via
 * entrada e saída de texto no terminal.
 * 
 * Esta classe usa um objeto da classe LeitorDeEntrada para ler entradas digitadas
 * pelo usuário e um objeto da classe Respondedor para gerar as respostas.
 * Ela tem um lopp que, repetidamente, lê uma entrada e gera uma saída até que
 * os usuários queiram sair.
 * 
 * Traduzido por Julio César Alves - 2023.10.17
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class SistemaDeSuporte
{
    private LeitorDeEntrada leitor;
    private Respondedor respondedor;
    
    /**
     * Cria um sistema de suporte técnico.
     */
    public SistemaDeSuporte()
    {
        leitor = new LeitorDeEntrada();
        respondedor = new Respondedor();
    }

    /**
     * Inicia o sistema de suporte técnico. Começa com a impressão
     * de uma mensagem de boas-vindas e entrada em um diálogo com o
     * usuário, até que o usuário termine a conversa.
     */
    public void iniciar()
    {
        boolean terminou = false;

        imprimirBoasVindas();

        while(!terminou) {
            String entrada = leitor.obterEntrada();
            entrada = entrada.trim();
            entrada = entrada.toLowerCase();

            if(entrada.equals("tchau")) {
                terminou = true;
            }
            else {
                String resposta = respondedor.generateResponse(entrada);
                System.out.println(resposta);
            }
        }

        imprimirDespedida();
    }

    /**
     * Imprime na tela uma mensagem de boas-vindas.
     */
    private void imprimirBoasVindas()
    {
        System.out.println("Bem-vindo(a) ao Sistema de Suporte Técnico da DesonestosSistemas.");
        System.out.println();
        System.out.println("Por favor, nos informe seu problema.");
        System.out.println("Podemos resolver qualquer problema que você tenha.");
        System.out.println("Por favor, digite 'tchau' para sair do nosso sistema.");
    }

    /**
     * Imprime uma mensagem de despedida na tela.
     */
    private void imprimirDespedida()
    {
        System.out.println("Foi um prazer te atender. Até a próxima...");
    }
}
