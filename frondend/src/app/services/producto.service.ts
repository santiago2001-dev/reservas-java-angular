import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

import { product } from '../models/product';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  url = 'http://localhost:8090/api/producto'
  urlP = 'http://localhost:8090/api/personalizadas'

  constructor(
    private http : HttpClient
  ) { }


  getAllProduct():Observable<any>{
    return this.http.get(this.url);
  }

  getProductByid(id:any):Observable<any>{
    return this.http.get(this.url+'/'+id);
    
  }

  getProximos():Observable<any>{
    return this.http.get(this.urlP);
  }

  addProduct(Product: product):Observable<any>{
    return this.http.post(this.url,Product);

  }


  updateProduct(id:any,producto:product):Observable<any>{
    return this.http.patch(this.url+'/'+id,producto);
  }


  deleteProduct(id:any):Observable<any>{
    return this.http.delete(this.url+'/'+id);
  }
}
