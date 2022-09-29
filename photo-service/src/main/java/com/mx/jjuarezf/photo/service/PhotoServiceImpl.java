package com.mx.jjuarezf.photo.service;

import com.mx.jjuarezf.photo.exception.EmptyException;
import com.mx.jjuarezf.photo.model.dto.PhotoDTO;
import com.mx.jjuarezf.photo.model.entity.Photo;
import com.mx.jjuarezf.photo.repository.PhotoRepositiry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotoRepositiry photoRepositiry;
    @Override
    public List<Photo> listar() {

        return (List<Photo>) photoRepositiry.findAll();

    }

    @Override
    public Optional<Photo> listarById(Integer idPhoto) {
        return photoRepositiry.findById(idPhoto);
    }

    @Transactional
    @Override
    public Photo add(PhotoDTO photoDTO) {
        Photo photo = new Photo();
        photo.setPhoto(photoDTO.getPhoto());
        photo.setDescription(photoDTO.getDescription());
        photo.setAlbum(photoDTO.getAlbum());

        return photoRepositiry.save(photo);

    }
    @Transactional
    @Override
    public Photo edit(Photo photo) {

        return photoRepositiry.save(photo);
    }

    @Transactional
    @Override
    public Optional<Photo> deleteById(Integer id) {

        Optional<Photo> photo = photoRepositiry.findById(id);

        if (photo!=null){
            photoRepositiry.deleteById(id);
        }

        return photo;
    }
}
