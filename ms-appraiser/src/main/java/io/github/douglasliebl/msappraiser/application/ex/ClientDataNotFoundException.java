package io.github.douglasliebl.msappraiser.application.ex;

public class ClientDataNotFoundException extends Exception{
    public ClientDataNotFoundException(){
        super("Data related to CPF not found");
    }
}
