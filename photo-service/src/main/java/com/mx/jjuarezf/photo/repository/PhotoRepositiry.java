package com.mx.jjuarezf.photo.repository;

import com.mx.jjuarezf.photo.model.entity.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepositiry extends CrudRepository<Photo,Integer> {
}
