import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdminProductUpdate } from '../admin-product-update/model/adminProductUpdate';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminProductAddService {

  private BASE_URL:string = "/api/admin/products";

  constructor(private http:HttpClient) { }

  saveNewProduct(product:AdminProductUpdate):Observable<AdminProductUpdate>{
    return this.http.post<AdminProductUpdate>(this.BASE_URL,product);
  }

}
