import { Injectable } from '@angular/core';
import { Product } from './model/product';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Page } from 'src/app/shared/model/page';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private BASE_URL:string = "/api/products"

  products: Product[] = [];

  constructor(private http:HttpClient) { }


  getProducts(page: number, size:number):Observable<Page<Product>>{
    return this.http.get<Page<Product>>(`${this.BASE_URL}?page=${page}&size=${size}`);
  }
}
