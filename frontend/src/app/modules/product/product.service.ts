import { Injectable } from '@angular/core';
import { Product } from './model/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  products: Product[] = [
    {
      name: 'Product 1',
      category: 'Kategoria 1',
      description: 'Opis produktu 1',
      price: 10.99,
      currency: 'PLN',
    },
    {
      name: 'Product 2',
      category: 'Kategoria 2',
      description: 'Opis produktu 2',
      price: 30.99,
      currency: 'PLN',
    },
    {
      name: 'Product 3',
      category: 'Kategoria 3',
      description: 'Opis produktu 3',
      price: 16.99,
      currency: 'PLN',
    },
  ];

  constructor() { }


  getProducts():Product[]{
    return this.products;
  }
}
