
/**
 * Escreva uma descrição da classe item aqui.
 * 
 * @author (seu nome) 
 * @version (um número da versão ou uma data)
 */
public class Cartas
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private String descricaoItem;

    /**
     * Construtor para objetos da classe item
     */
    public Cartas(String nome, String descricao)
    {
        this.nome = nome;
        descricaoItem = descricao;
    }
    
    public String getNomeItem(){
        return nome;
    }
    
    public String getDescricaoItem(){
        return descricaoItem;
    }
}
