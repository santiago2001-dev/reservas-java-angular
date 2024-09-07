import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { reserva } from '../models/reserva';
import {HttpClient} from '@angular/common/http'


@Injectable({
  providedIn: 'root'
})
export class ReservaService {

  url = 'http://localhost:8090/api/reserva';

  constructor(
    private http : HttpClient
  ) { }



  getAllreserva():Observable<any>{
    return this.http.get(this.url);
  }

  getreservaByid(id:any):Observable<any>{
    return this.http.get(this.url+'/'+id);
    
  }



  addreserva(reserva: reserva):Observable<any>{
    return this.http.post(this.url,reserva);

  }


  updatereserva(id:any,reserva:reserva):Observable<any>{
    return this.http.put(this.url+'/'+id,reserva);
  }


  deleteReserva(id:any):Observable<any>{
    return this.http.delete(this.url+'/'+id);
  }
}
