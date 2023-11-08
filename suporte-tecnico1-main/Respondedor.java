import java.util.Random;

/**
 * A classe Respondendor representa um objeto gerador de respostas.
 * É usado para gerar uma resposta automática para uma string de entrada.
 * 
 * Traduzido por Julio César Alves - 2023.10.17
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class Respondedor
{
    // declara o ArrayList que armazena as respostas
    //private String respostas[];
    /**
     * Constrói um respondedor - nada a fazer.
     */
    public Respondedor()
    {
        //respostas = new String[9];
        //respostas[0] = "Isso parece estranho. Você poderia descrever com mais detalhes?";
        //respostas[1] = "Nenhum outro cliente reclamou disso antes. Qual é a configuração do seu sistema?";
        //respostas[2] = "Poderia me dar mais informações sobre o problema?";
        //respostas[3] = "Isso é abordado no manual. Você já leu o manual?";
        //respostas[4] = "Sua descrição é um pouco ruim. Você tem um especialista com você que poderia descrever isso melhor?";
        //respostas[5] = "Isso não é um bug, é uma funcionalidade!";
        //respostas[6] = "Você poderia detalhar melhor isso?";
        //respostas[7] = "Você já tentou executar o aplicativo no seu telefone?";
        //respostas[8] = "Já verifiquei no StatckOverflow e ChatGPT e nem eles sabem como responder :(";
    }

    /**
     * Gera uma resposta.
     * @return Uma string que deveria ser exibida como resposta.
     */
    public String generateResponse(String mensagem)
    {
        //Random randomizador = new Random();
        //return respostas[randomizador.nextInt(9)];
        if ((mensagem.contains("travou")) || (mensagem.contains("travado")))
        {
            return "Bem, nunca trava em nosso sistema. Deve ter algo a ver com o seu sistema. Conte mais sobre sua configuração.";
        }
        else if (mensagem.contains("lento"))
        {
            return "Acredito que isso tem a ver com o seu hardware. Atualizar seu processador deve resolver todos os problemas de desempenho. Você tem algum problema com nosso software?";
        }
        else if (mensagem.contains("bug"))
        {
            return "Bem, você sabe, todo software tem alguns bugs. Mas nossos engenheiros de software estão trabalhando muito para corrigi-los. Você pode descrever o problema com mais detalhes?";
        }
        return "Iremos analisar a situaçao e depois te retornamos";
    }
}
