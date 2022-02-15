import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Student} from "./Student";

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  constructor(public http: HttpClient) { }

  public findAll() {
    return this.http.get<Student[]>("/api/v1/student/all");
  }

  public findById(id: number) {
    return this.http.get<Student>(`/api/v1/student/${id}`);
  }
}
