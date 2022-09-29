package com.mx.jjuarezf.photo.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
@Getter
public class EmptyException {

    private final HttpStatus status;

    private final String level;


    public EmptyException() {
        this.status = HttpStatus.NO_CONTENT;
        this.level = "warning";
    }
}
