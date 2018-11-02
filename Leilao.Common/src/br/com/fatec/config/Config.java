package br.com.fatec.config;

public class Config {
    // indica que irá usar a configuração "fake" para simular acesso ao banco e 
    // conseguir testar a aplicação sem uso do sql
    // -- usar true apenas para teste --
    public static final boolean USE_FAKE_PROVIDER = true;
    
    public static final int PORT = 8089;
    public static final String REGISTRY = "localhost";
    public static final String ENDPOINT_BASE = "rmi://" + REGISTRY + ":" + PORT;
    
    public static final String ENDPOINT_LOGIN = ENDPOINT_BASE + "/Login";
}
