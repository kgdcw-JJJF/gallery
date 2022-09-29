import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Photo } from 'src/app/model/Photo';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css'],
  
})
export class AddComponent implements OnInit {

  constructor(private router:Router, private service:ServiceService) { }

  ngOnInit(): void {
  }


  modelPhoto: Photo = new Photo; 

  guardar(photo:Photo){
    this.service.createPhoto(photo)
    .subscribe(data=>{
      alert("se agrego");
      this.router.navigate(["listar"])
    })
  }


}
