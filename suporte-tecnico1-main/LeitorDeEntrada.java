import java.util.HashSet;
import java.util.Scanner;

/**
 * LeitorDeEntrada lê o texto digitado pelo usuário na entrada padrão do
 * terminal de texto.
 * O texto digitado pelo usuário é retornado.
 * 
 * Traduzido por Julio César Alves - 2023.10.17
 * 
 * @author     Michael Kölling and David J. Barnes
 * @version    0.1 (2016.02.29)
 */
public class LeitorDeEntrada
{
    private Scanner leitor;

    /**
     * Cria um novo LeitorDeEntrada que lê texto a partir do terminal.
     */
    public LeitorDeEntrada()
    {
        leitor = new Scanner(System.in);
    }

    /**
     * Lê uma linha de texto da entrada padrao (o terminal), e
     * a retorna como uma String.
     *
     * @return  Uma string digitada pelo usuário.
     */
    public String obterEntrada()
    {
        System.out.print("> ");         // imprime o prompt
        String inputLine = leitor.nextLine();

        return inputLine;
    }
}
