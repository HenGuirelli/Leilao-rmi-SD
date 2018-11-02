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
    public static final String ENDPOINT_LEILAO = ENDPOINT_BASE + "/Leilao";
    
    public class Texts {
        
        public class Error {
            public static final String REMOTE_EXCEPTION = "Erro ao conectar";
            public static final String CREATE_ACCOUNT = "Conta já cadastrada";
            public static final String LOGIN = "Usuario ou senha incorretos";
        }
        
        public class Success {
            public static final String CREATE_ACCOUNT = "Conta criada";
            public static final String REGISTER_ITEM = "Item em leilão";  
        }
        
    }
}
