import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Photo } from '../model/Photo';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  Url='http://localhost:8080/album/photo/all';
  save='http://localhost:8080/album/photo/save';
  edit='http://localhost:8080/album/user/update';
  urlFindById='http://localhost:8080/album/photo/find';
  urlDeleteById='http://localhost:8080/album/user/delete';
  getPhoto(){
    console.log("llama microservicio");
    return this.http.get<Photo[]>(this.Url)
  }

  createPhoto(Photo:Photo){
    return this.http.post<Photo>(this.save,Photo);
  }

  updatePhoto(photo:Photo){
    return this.http.put<Photo>(this.edit+"/"+photo.idPhoto,photo);
  }

  getPhotoId(idPhoto:number){
    console.log("llamando photo por id: "+idPhoto);
    return this.http.get<Photo>(this.urlFindById+"/"+idPhoto)
  }
  deletePhoto(photo:Photo){
    return this.http.delete<Photo>(this.urlDeleteById+"/"+photo.idPhoto);
  }
}
