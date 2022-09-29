package com.mx.jjuarezf.photo.controller;

import com.mx.jjuarezf.photo.model.dto.PhotoDTO;
import com.mx.jjuarezf.photo.model.entity.Photo;
import com.mx.jjuarezf.photo.service.PhotoService;
import com.mx.jjuarezf.photo.utils.ConstantService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/album")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @ApiOperation(value = "Crea un nueva foto")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = ConstantService.MESSAGE_OK,response = Photo.class),
            @ApiResponse(code = 400,message = ConstantService.MESSAGE_BAD_REQEST,response = String.class),
            @ApiResponse(code = 500, message = ConstantService.MESSAGE_SERVICE_UNAVAILABLE,response = String.class)})
    @PostMapping(value = "/photo/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveUser(@Valid @RequestBody PhotoDTO photoDTO){

        return new ResponseEntity<>(photoService.add(photoDTO),HttpStatus.OK);
    }

    @ApiOperation(value = "Busca todas las photos")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = ConstantService.MESSAGE_OK, response = List.class),
            @ApiResponse(code = 204, message = ConstantService.MESSAGE_NO_CONTEN, response = String.class),
            @ApiResponse(code = 503, message = ConstantService.MESSAGE_SERVICE_UNAVAILABLE,response = String.class)})
    @GetMapping(value = "/photo/all",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> userFindAll(){

        return new ResponseEntity<>(photoService.listar(), HttpStatus.OK);

    }

    @ApiOperation(value = "Busca foto por id")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = ConstantService.MESSAGE_OK, response = Photo.class),
            @ApiResponse(code = 204, message = ConstantService.MESSAGE_NO_CONTEN, response = String.class),
            @ApiResponse(code = 503, message = ConstantService.MESSAGE_SERVICE_UNAVAILABLE,response = String.class)})
    @GetMapping(value = "/photo/find/{idPhoto}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> userFindByEmail(@PathVariable Integer idPhoto){

        log.info("buscando foto por id: "+idPhoto);

        return new ResponseEntity<>(photoService.listarById(idPhoto), HttpStatus.OK);

    }

    @ApiOperation(value = "actualiza  photo")
    @ApiResponses(value ={
            @ApiResponse(code = 200, message = ConstantService.MESSAGE_OK, response =  Photo.class),
            @ApiResponse(code = 400,message = ConstantService.MESSAGE_BAD_REQEST, response = String.class),
            @ApiResponse(code = 204, message = ConstantService.MESSAGE_NO_CONTEN, response = String.class),
            @ApiResponse(code = 500, message = ConstantService.MESSAGE_SERVICE_UNAVAILABLE, response = String.class)})
    @PutMapping( value = "/user/update/{idPhone}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> photoUpdateById(@Valid @RequestBody Photo photo, @PathVariable("idPhone") Integer idPhone ){
        photo.setIdPhoto(idPhone);


        return new ResponseEntity<>(photoService.edit(photo), HttpStatus.OK);

    }

    @ApiOperation(value = "eliminar foto")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = ConstantService.MESSAGE_OK, response = Photo.class),
            @ApiResponse(code = 204, message = ConstantService.MESSAGE_NO_CONTEN,response = String.class),
            @ApiResponse(code = 400, message = ConstantService.MESSAGE_BAD_REQEST, response = String.class),
            @ApiResponse(code = 500, message = ConstantService.MESSAGE_SERVICE_UNAVAILABLE,response = String.class)})
    @DeleteMapping(value = "/user/delete/{idPhoto}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> userDelete(@PathVariable Integer idPhoto){
        return new ResponseEntity<>(photoService.deleteById(idPhoto),HttpStatus.OK);
    }
}
