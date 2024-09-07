import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { product } from '../../models/product';
import { ReservaService } from 'src/app/services/reserva.service';
import { reserva } from 'src/app/models/reserva';
import { LoginService } from 'src/app/services/login.service';
import { user } from 'src/app/models/login';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {
  reservaForm : FormGroup;
  Id : String |null;
  Titulo = 'Crear reserva';
  users: user[] = []

  constructor(
    private router: Router,
    private fb : FormBuilder,
    private aRouter  : ActivatedRoute,  
    private serv : ReservaService,

    private usersService: LoginService
  ) {

    this.reservaForm = this.fb.group({
      id_user : ['',Validators.required],
      fecha : ['',Validators.required],
      estado : [true,Validators.required],
    })
      
    this.Id = this.aRouter.snapshot.paramMap.get('id');
  }
   


  ngOnInit(): void {
    this.esEditar();
    this.getallUsers();
    
  }


createReserva(){
  if(this.reservaForm.invalid){
    swal.fire({
      icon: 'error',
      title: 'los campos son obligatorios',
    
    })

  }else{
    
    const reserva : reserva = {
      id_user : this.reservaForm.get('id_user')?.value,
      fecha : this.reservaForm.get('fecha')?.value,
      estado: this.reservaForm.get('estado')?.value,
    }
  if(this.Id !==null){

    this.serv.updatereserva(this.Id,reserva).subscribe(
      data=>{
        swal.fire({
          position: 'center',
          icon: 'success',
          title: 'reserva actualizada',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/']);

      },error=>{
        console.log(error)
        swal.fire({
          icon: 'error',
          title: 'algo salio mal intenta de nuevo porfavor ',
        
        })

        // this.reservaForm.reset(); 
      }
      
    )
  }else{
    this.serv.addreserva(reserva).subscribe(
      data =>{
        swal.fire({
          position: 'center',
          icon: 'success',
          title: 'reserva se agrego correctamente',
          showConfirmButton: false,
          timer: 1500
        })
        this.router.navigate(['/']);

      },error=>{
        swal.fire({
          icon: 'error',
          title: 'algo salio mal intenta de nuevo porfavor ',
        
        })
        this.reservaForm.reset(); //limpiar formulario
      }

    )
  }
}

}

esEditar(){
  if(this.Id !== null){
    this.Titulo = 'Editar reserva';
    this.serv.getreservaByid(this.Id).subscribe(
      data=>{
        console.log(data)
        this.reservaForm.patchValue({
          id_user: data.id_user,
          fecha:data.fecha,
          estado : data.estado
        })
      },error=>{
          console.log(error)
      }
      
    )

  }

}


getallUsers() {
  this.usersService.getAllUsers().subscribe(
    data=>{
      this.users =  data;
      
    },error=>{
        console.log(error)
    }
    
  )  

}
}
