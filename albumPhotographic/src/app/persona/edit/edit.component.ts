import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Photo } from 'src/app/model/Photo';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  photo: Photo = new Photo();
  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
    this.Editar();
  }

  modelPhoto: Photo = new Photo; 

  Editar(){  
    console.log("editar de edit");
    let id=localStorage.getItem("idPhoto")    
    console.log("id: "+id);
    this.service.getPhotoId(+id)
    .subscribe(data=>{
      this.modelPhoto=data;

    })
  }

 

  Actualizar(photo:Photo){
    this.service.updatePhoto(photo)
    .subscribe(data=>{
      this.photo=data;
      alert("se actualizo foto");
      this.router.navigate(["listar"])
    })
  }

}
