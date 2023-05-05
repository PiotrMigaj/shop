import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AdminProductUpdate } from './model/adminProductUpdate';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root',
})
export class AdminProductUpdateService {

  private BASE_URL:string = "/api/admin/products/"

  constructor(private http: HttpClient) {}

  getProduct(id:number):Observable<AdminProductUpdate> {
    return this.http.get<AdminProductUpdate>(this.BASE_URL+id);
  }

  saveProduct(id:number,value:AdminProductUpdate){
    return this.http.put<AdminProductUpdate>(this.BASE_URL+id,value);
  }
}
