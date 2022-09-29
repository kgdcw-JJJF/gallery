package com.mx.jjuarezf.photo.model.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "photo")//galery
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_photo")
    private Integer idPhoto;

    @Column(name = "photo")
    private String photo;


    @Column(name = "description")
    private String description;

    @NonNull
    @Column(name = "album")
    private String album;






}
