package com.mx.jjuarezf.photo.service;

import com.mx.jjuarezf.photo.model.dto.PhotoDTO;
import com.mx.jjuarezf.photo.model.entity.Photo;

import java.util.List;
import java.util.Optional;

public interface PhotoService {

List<Photo> listar();

Optional<Photo> listarById(Integer idPhoto);
Photo add(PhotoDTO photoDTO);
Photo edit(Photo photo);
Optional<Photo> deleteById(Integer id);
}
