/**
 *  Essa eh a classe principal da aplicacao "World of Zull".
 *  "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *  Usuarios podem caminhar em um cenario. E eh tudo! Ele realmente
 *  precisa ser estendido para fazer algo interessante!
 * 
 *  Para jogar esse jogo, crie uma instancia dessa classe e chame o metodo
 *  "jogar".
 * 
 *  Essa classe principal cria e inicializa todas as outras: ela cria os
 *  locais, cria o analisador e comeca o jogo. Ela tambeme avalia e 
 *  executa os comandos que o analisador retorna.
 * 
 * Traduzido por Julio César Alves. Versão: 2023.10.21
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Jogo 
{
    private Analisador analisador;
    private Local localAtual;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() 
    {
        criarLocais();
        analisador = new Analisador();
    }

    /**
     * Cria todos os locais e liga as saidas deles
     */
    private void criarLocais()
    {
        Local saguao, balcao, mesaDeBaralho, laboratorio, quadro, porao;
        Cartas baralhoDoBebado, baralhoDoMago, baralhoDoLadrao;
        
        // cria os baralhos
        baralhoDoBebado = new Cartas("Deck do Bebado", "Entre dois barris voce encontra um conjunto de cartas de um lado um cristal fosco e do outro com uma joia de cor vinho encrustado em madeira do mesmo tipo que os barries a sua volta."
                                        +"\nVoce sente um cheiro forte de alcool vindo delas.");
        baralhoDoLadrao = new Cartas("Deck do Ladrao", "Voce pergunta para o homem ao lado sobre o quadro e ele responde: 'Entao deseja jogar? Pegue e descubra por si.' \n"
                                        + "Voce acaba de receber um conjunto de cartas de um lado um cristal fosco e do outro com uma joia preta brilhante como o ceu noturno com detalhes em volta dela fietos de couro"
                                        + "\nVoce consegue ver manchas de sangue no couro.");
        baralhoDoMago = new Cartas("Deck do Mago", "Em cima da mesa bagunçada voce encontra um conjunto de cartas de um lado feito com um cristal fosco e de outro com uma joia azul reluzante com detlahes em volta feito de escamas grossas de seres que nunca viu"
                                        + "\nVoce consegue sentir sua queimar pela luz que essas cartas emitem");
      
        // cria os locais
        saguao = new Local("Voce se encontra dentro da taverna vendo pessoas jogando a oeste, um balcao de bebidas e alimentos ao leste com um javali sorridante a limpar uma caneca de vidro a direta \n"
        + "um painel vazio com tres espaços para serem preenchidos com algum objeto retangular e ao sul a porta do estabelecimento onde acima se encontra uma placa escrito: 'Volte sempre!'");
        balcao = new Local("Voce esta em frente a um balcao do bar onde na parede se encontra algumas bebidas de procedencia duvidosa. O javali atras do balcao pergunta: \n 'Ja chegou a jogar '"
        + "o Baralho mistico? Se nao, experimente acho que vai gostar.");
        mesaDeBaralho = new Local("Voce se encontra em frente a uma mesa com um tabuleiro feito de um cristal reluzente que parece sussurar em seu ouvido uma lingua ja esquecida no tempo. \n"
        + "O senhor de rosto tampado pelo capuz sentado do outro lado da mesa pergunta: 'Deseja jogar filho ?'");
        laboratorio = new Local("Voce se encontra numa sala iluminada por velas com a chama azul e uma mesa com objetos que nao consegue imaginar a serventia espalhados em cima dela. \n" +
        "Uma mulher esta sentada lendo um livro em que mesmo tentando chama-la ela parece nao ligar para sua presença.", baralhoDoMago);
        quadro = new Local("Voce se depara com um quadro feito contornado por madeira e forrado com um tecido veremlho que lembra um tecido usado pela realeza. \n"
        + "Um homem parado ao lado que instiga sua curiosidade.", baralhoDoLadrao);
        porao = new Local("No balcao onde o javali se encontra ha um alçapao em que voce pergunta sobre ele e tem como resposta: 'E somente onde eu guardo as bebidas mais caras.' \n" +
        "Ao descer as escadas do alçapao voce ve diversos barris de bebida.", baralhoDoBebado);
        
        
        // inicializa as saidas dos locais
        saguao.ajustarSaida("norte", quadro);
        saguao.ajustarSaida("leste", balcao);
        saguao.ajustarSaida("oeste", mesaDeBaralho);
        
        balcao.ajustarSaida("oeste", saguao);
        balcao.ajustarSaida("baixo", porao);
        
        laboratorio.ajustarSaida("sul", mesaDeBaralho);
        
        mesaDeBaralho.ajustarSaida("norte", laboratorio);
        mesaDeBaralho.ajustarSaida("leste", saguao);
        
        quadro.ajustarSaida("sul", saguao);
        
        porao.ajustarSaida("cima", balcao);

        localAtual = saguao;  // o jogo comeca do lado de fora
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() 
    {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.obterComando();
            terminado = processarComando(comando);
        }
        System.out.println("Voce percebe que a ventania e a tempestade do lado de fora ja acalmou e entao caminha para a porta de madeira no saguao e olha para a placa acima dela escrito volte sempre!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Voce, um viajante que acaba de retornar de sua aventura epica, busca um local em meio para descansar em meio noite de ventos que tentam te puxar para fora do cavalo.");
        System.out.println("Ao longe, voce enxerga uma luz amerela cintilinado como fogo de vela saido de uma janela e ao se aproximar enxerga uma placa iluminada por ela escrito, Bar do Porcao..");
        System.out.println("Voce entra desesperado no abrigo e encontro nele uma noite peculiar com sujeitos peculiares.");
        System.out.println();
    
        imprimirLocalAtual();
    }

    /**
     * Dado um comando, processa (executa) o comando.
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando) 
    {
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.obterPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaLocal(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }
        else if (palavraDeComando.equals("observar")) {
            observar(comando);
        }
        else if (palavraDeComando.equals("pegar")) {
            pegarCarta(comando);
        }

        return querSair;
    }
    
    private void pegarCarta(Comando comando)
    {
        if (localAtual.obterExistemCartas())
        {
            System.out.println(localAtual.obterCarta().getDescricaoItem());
            System.out.println("Voce acaba de coletar o " + localAtual.coletarCarta().getNomeItem());
        }
        else
            System.out.println("Nao ha nenhuma carta para ser coletada.");
    }
    
    private void observar(Comando comando)
    {
        imprimirLocalAtual();
        System.out.println(localAtual.observar());
    }

    // Implementacoes dos comandos do usuario

    /**
     * Imprime informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        System.out.println("Voce acaba de entrar numa taverna com animais antropomorfizados em que, ao se aproximar do balcao de bebidas, e calorosamente recepiciado por um velho javali se apoiando");
        System.out.println("sobre a bancada e entao diz:");
        System.out.println("Bem vindo caro viajante, meu nome e Porcao, busca descanso, conforto, comida e bebida ao seu dispor e diversao ? Bem, entao esta no lugar certo.");
        System.out.println("Vou te apresentar como as coisas funcionam: use o comando ir mais a direça(sul, norte, leste ou oeste) para andar pelo estabelecimento e o comando interagir");
        System.out.println("quando o sala permitir. Caso precise se lembrar como as coisas funcionam, use o comando ajuda. Aproveite!");
        System.out.println(analisador.getComandosValidos());
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo local, caso contrario imprime mensagem de erro.
     */
    private void irParaLocal(Comando comando) 
    {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.obterSegundaPalavra();

        // Tenta sair do local atual
        Local proximoLocal = null;
        proximoLocal = localAtual.obterSaida(direcao);

        if (proximoLocal == null) {
            System.out.println("Nao ha passagem!");
        }
        else {
            localAtual = proximoLocal;
            
            imprimirLocalAtual();
        }
    }
    
    private void imprimirLocalAtual()
    {
        System.out.println(localAtual.obterDescricaoLonga());
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
}
