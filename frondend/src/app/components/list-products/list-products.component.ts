import { Component, OnInit } from '@angular/core';
import {product} from 'src/app/models/product';
import swal from 'sweetalert2';
import { ProductoService} from 'src/app/services/producto.service';
import { Router, RouterOutlet } from '@angular/router';
import { ReservaService } from 'src/app/services/reserva.service';
import { reserva } from 'src/app/models/reserva';
@Component({
  selector: 'app-list-products',
  templateUrl: './list-products.component.html',
  styleUrls: ['./list-products.component.css']
})
export class ListProductsComponent implements OnInit {
  listReserva: reserva[] =  []; 
 

  constructor(
    private servi : ReservaService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.getProduct()
    
  }


  getProduct(){
    this.servi.getAllreserva().subscribe(
      data=>{
        this.listReserva = data;
   
      },error=>{
        swal.fire({
          icon: 'error',
          title: 'Sin conexión a la base de datos ',
        
        })
      }
    )


   
  


  }



  deleteProduct(id : any){
 
    const swalWithBootstrapButtons = swal.mixin({
      customClass: {
        confirmButton: 'btn btn-success',
        cancelButton: 'btn btn-danger'
      },
      buttonsStyling: false
    })
    
    swalWithBootstrapButtons.fire({
      title: '¿estás seguro?',
      text: "Una vez eiminado el contacto no podrá ser recuperado!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'si, deseo eliminarlo',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true
    }).then((result) => {
      if (result.isConfirmed) {
  
        this.servi.deleteReserva(id).subscribe(
          data=>{
          swalWithBootstrapButtons.fire(
          'producto eliminado!',
          'el producto ha sido eliminado correctamente',
          'success'
        )
        window.location.reload()
        this.getProduct()
  
      },error=>{
        swal.fire({
          icon: 'error',
          title: 'algo salio mal intenta de nuevo ',
        
        })
  
  
      }
      )
      } else if (
        /* Read more about handling dismissals below */
        result.dismiss === swal.DismissReason.cancel
      ) {
        swalWithBootstrapButtons.fire(
          'Cancelado',
          'operación cancelada',
          'error'
        )
      }
    })
    

  }




}