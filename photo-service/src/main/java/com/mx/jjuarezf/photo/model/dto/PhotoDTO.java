package com.mx.jjuarezf.photo.model.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.sql.Blob;

@Data
public class PhotoDTO {

    private String photo;

    private String description;

    @NotNull(message = "el campo album no puede ser nulo")
    private String album;

}
