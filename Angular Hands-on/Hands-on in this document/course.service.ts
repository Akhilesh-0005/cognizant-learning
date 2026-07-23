import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, map, retry, tap, throwError } from 'rxjs';
import { Course } from './course.model';

@Injectable({providedIn:'root'})
export class CourseService {
  private api='http://localhost:3000/courses';
  constructor(private http:HttpClient){}
  getCourses():Observable<Course[]> {
    return this.http.get<Course[]>(this.api).pipe(
      map(cs=>cs.filter(c=>c.credits>0)),
      tap(cs=>console.log('Courses loaded:',cs.length)),
      retry(2),
      catchError(err=>throwError(()=>new Error('Failed to load courses. Please try again.')))
    );
  }
  getCourseById(id:number):Observable<Course>{return this.http.get<Course>(`${this.api}/${id}`);}
  createCourse(course:Omit<Course,'id'>){return this.http.post<Course>(this.api,course);}
  updateCourse(id:number,course:Partial<Course>){return this.http.put<Course>(`${this.api}/${id}`,course);}
  deleteCourse(id:number){return this.http.delete(`${this.api}/${id}`);}
}