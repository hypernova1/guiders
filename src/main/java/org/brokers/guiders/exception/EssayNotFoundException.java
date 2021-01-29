package org.brokers.guiders.exception;

public class EssayNotFoundException extends RuntimeException {

    public EssayNotFoundException(Long id) {
        super("존재하지 않는 에세이 입니다. id: " + id);
    }
}
