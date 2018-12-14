package br.com.fatec.exceptions;

public class ContaInexistenteException extends Exception {
    public ContaInexistenteException(){
        super("Login ou usuario inválidos");
    }
}
