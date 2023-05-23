import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminCategoryNamesDto } from '../common/dto/adminCategoryNamesDto';
import { AdminCategory } from './model/adminCategory';


@Injectable({
  providedIn: 'root'
})
export class AdminCategoryService {
  

  private BASE_URL: string = '/api/admin/categories';

  constructor(private http: HttpClient) { }

  getCategories():Observable<Array<AdminCategoryNamesDto>>{
    return this.http.get<Array<AdminCategoryNamesDto>>(this.BASE_URL);
  }
  createCategory(value:any):Observable<AdminCategory>{
    return this.http.post<AdminCategory>(this.BASE_URL,value);
  }
  getCategory(id: number):Observable<AdminCategory> {
      return this.http.get<AdminCategory>(`${this.BASE_URL}/${id}`);
  }
  saveProduct(id:number,value:any):Observable<AdminCategory>{
    return this.http.put<AdminCategory>(`${this.BASE_URL}/${id}`,value);
  }
  delete(id:number):Observable<void>{
    return this.http.delete<void>(`${this.BASE_URL}/${id}`);
  }

}
