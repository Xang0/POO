import java.util.HashMap;
/**
 * Classe Local - um local em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.  
 *
 * Um "Local" representa um lugar no cenario do jogo. Ele eh conectado 
 * aos outros locais atraves de saidas. As saidas sao nomeadas como 
 * norte, sul, leste e oeste. Para cada direcao, o local guarda uma 
 * referencia para o local vizinho, ou null se nao ha saida naquela 
 * direcao.
 * 
 * Traduzido por Julio César Alves. Versão: 2023.10.21
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Local 
{
    private String descricao;
    private HashMap<String,Local> saidas;
    private Cartas cartas;
    private boolean existemCartas;

    /**
     * Cria um local com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "um jardim aberto".
     * @param descricao A descricao do local.
     */
    public Local(String descricao) 
    {
        this.descricao = descricao;
        saidas = new HashMap<>();
        existemCartas = false;
    }
    
    public Local(String descricao, Cartas cartas) 
    {
        this.descricao = descricao;
        saidas = new HashMap<>();
        this.cartas = cartas;
        existemCartas = true;
    }

    /**
     * Define as saidas do local. Cada direcao ou leva a um
     * outro local ou eh null (nenhuma saida para la).
     * @param norte A saida norte.
     * @param leste A saida leste.
     * @param sul A saida sul.
     * @param oeste A saida oeste.
     */
    public void ajustarSaida(String direcao, Local local)
    {
        if(local != null)
            saidas.put(direcao, local);
    }

    /**
     * @return A descricao do local.
     */
    public String obterDescricao()
    {
        return descricao;
    }
    
    public Local obterSaida(String direcao)
    {
        return saidas.get(direcao);
    }
    
    public String obterDirecoesSaida()
    {
        String direcoes = "";
        for (String direcao: saidas.keySet())
        {
            direcoes += direcao + " ";
        }
        
        return direcoes;
    }
    
    public String observar()
    {
        String descricaoCarta;
        if (existemCartas)
        {
            descricaoCarta = "Existem cartas nessa sala.";
        }
        else
        {
            descricaoCarta = "Nao existe nenhuma carta a ser encontrada.";
        }
        
        return descricaoCarta;
    }
    
    public String obterDescricaoLonga()
    {
        return obterDescricao() + "\nSaidas: " + obterDirecoesSaida() + "\n";
    }
    
    public boolean obterExistemCartas()
    {
        return existemCartas;
    }
    
    public Cartas obterCarta()
    {
        if (cartas != null)
            return cartas;
        return null;
    }
    
    public Cartas coletarCarta()
    {
        Cartas auxiliar = cartas;
        cartas = null;
        return auxiliar;
    }
}
