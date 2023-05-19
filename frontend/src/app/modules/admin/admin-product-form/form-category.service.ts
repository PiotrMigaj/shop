import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdminCategoryNamesDto } from './adminCategoryNamesDto';

@Injectable({
  providedIn: 'root'
})
export class FormCategoryService {

  private BASE_URL: string = '/api/admin/categories';

  constructor(private http: HttpClient) { }

  getCategories():Observable<Array<AdminCategoryNamesDto>>{
    return this.http.get<Array<AdminCategoryNamesDto>>(this.BASE_URL);
  }
}
