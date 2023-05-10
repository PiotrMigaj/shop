import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AdminProduct } from './adminProduct';
import { Page } from 'src/app/shared/model/page';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AdminProductService {
  private BASE_URL: string = '/api/admin/products';

  constructor(private http: HttpClient) {}

  getProducts(page: number, size: number): Observable<Page<AdminProduct>> {
    return this.http.get<Page<AdminProduct>>(
      `${this.BASE_URL}?page=${page}&size=${size}`
    );
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.BASE_URL}/${id}`);
  }
}
