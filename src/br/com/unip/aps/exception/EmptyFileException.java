package br.com.unip.aps.exception;

public class EmptyFileException extends RuntimeException {

    public EmptyFileException() {
        super("The file is empty.");
    }

}
