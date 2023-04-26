import { Injectable } from '@angular/core';
import { Product } from './model/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private BASE_URL:string = "/api/products"

  products: Product[] = [];

  constructor(private http:HttpClient) { }


  getProducts():Observable<Product[]>{
    return this.http.get<Product[]>(this.BASE_URL);
  }
}
