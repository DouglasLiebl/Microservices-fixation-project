package io.github.douglasliebl.msappraiser.application.ex;

import lombok.Getter;

public class MicroservicesCommunicationErrorException extends Exception{

    @Getter
    private Integer status;

    public MicroservicesCommunicationErrorException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
