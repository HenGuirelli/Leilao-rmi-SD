package br.com.fatec.exceptions;

public class ContaExisteException extends Exception{
    public ContaExisteException(){
        super("Esse email já está cadastrado");
    }    
}
