package io.github.douglasliebl.msappraiser.application.ex;

// Tratamento de erro para usuário não encontrado;
public class ClientDataNotFoundException extends Exception{
    public ClientDataNotFoundException(){
        super("Data related to CPF not found");
    }
}
