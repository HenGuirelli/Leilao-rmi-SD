package br.com.fatec.config;

public class Config {
    // indica que irá usar a configuração "fake" para simular acesso ao banco e 
    // conseguir testar a aplicação sem uso do sql
    // -- usar true apenas para teste --
    public static final boolean USE_FAKE_PROVIDER = true; 
}
