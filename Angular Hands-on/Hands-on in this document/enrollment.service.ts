import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({providedIn:'root'})
export class EnrollmentService {
  private enrolledCourseIds:number[]=[];
  constructor(private http:HttpClient){}
  enroll(id:number){if(!this.enrolledCourseIds.includes(id))this.enrolledCourseIds.push(id);}
  unenroll(id:number){this.enrolledCourseIds=this.enrolledCourseIds.filter(x=>x!==id);}
  isEnrolled(id:number){return this.enrolledCourseIds.includes(id);}
  getIds(){return [...this.enrolledCourseIds];}
  getStudentsByCourse(id:number):Observable<any[]>{return this.http.get<any[]>(`http://localhost:3000/students?courseId=${id}`);}
}