package br.com.fatec.model;


public class ExecutionContext {    
    private static Usuario usuario;
    
    private ExecutionContext(){}

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        ExecutionContext.usuario = usuario;
    }
}
