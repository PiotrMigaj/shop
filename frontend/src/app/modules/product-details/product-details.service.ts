import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ProductDetails } from './model/productDetails';

@Injectable({
  providedIn: 'root'
})
export class ProductDetailsService {

  private BASE_URL:string = "/api/products/"

  constructor(private http:HttpClient) { }

  getProductDetails(slug:string):Observable<ProductDetails>{
    return this.http.get<ProductDetails>(this.BASE_URL+slug);
  }
}
