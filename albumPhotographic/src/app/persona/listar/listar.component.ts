import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Photo } from 'src/app/model/Photo';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  
  photos: Photo[] = []; 
  constructor(private service:ServiceService, private router:Router) { }

  ngOnInit(): void {
    this.service.getPhoto()
    .subscribe(data=>{
      this.photos=data;
    })
  }

  Editar(photo:Photo):void{
    localStorage.setItem("idPhoto",photo.idPhoto.toString());
    this.router.navigate(["edit"]);
  }

  Delete(photo:Photo){
    this.service.deletePhoto(photo)
    .subscribe(data=>{
      this.photos = this.photos.filter(p=>p!==photo);
      alert("photo eliminada")
    })
  }

}
