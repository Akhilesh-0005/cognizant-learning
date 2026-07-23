import { Component, OnInit } from '@angular/core'; import { CommonModule } from '@angular/common'; import { Router, ActivatedRoute } from '@angular/router'; import { CourseCardComponent } from './course-card.component'; import { HighlightDirective } from './highlight.directive'; import { CourseService } from './course.service'; import { Course } from './course.model';
@Component({standalone:true,imports:[CommonModule,CourseCardComponent,HighlightDirective],template:`<div class="container"><h1>Courses</h1><p *ngIf="isLoading">Loading courses...</p><p class="error" *ngIf="errorMessage">{{errorMessage}}</p><ng-container *ngIf="!isLoading"><div class="grid" *ngIf="courses.length;else noCourses"><app-course-card *ngFor="let c of courses;trackBy:trackByCourseId" [course]="c" appHighlight="lightblue" (enrollRequested)="onEnroll($event)"></app-course-card></div><ng-template #noCourses><p>No courses available.</p></ng-template></ng-container><p *ngIf="selectedCourseId">Selected course ID: {{selectedCourseId}}</p></div>`})
export class CourseListComponent implements OnInit {
 courses:Course[]=[];isLoading=true;errorMessage='';selectedCourseId?:number;searchTerm='';
 constructor(private service:CourseService,private router:Router,private route:ActivatedRoute){}
 ngOnInit(){this.searchTerm=this.route.snapshot.queryParamMap.get('search')||'';this.service.getCourses().subscribe({next:c=>this.courses=c,error:e=>{this.errorMessage=e.message;this.isLoading=false},complete:()=>this.isLoading=false});}
 // trackBy lets Angular reuse DOM nodes when unchanged list items keep the same id.
 trackByCourseId(_:number,c:Course){return c.id;} onEnroll(id:number){console.log('Enrolling in course: '+id);this.selectedCourseId=id;}
 openCourse(id:number){this.router.navigate(['courses',id]);}
 search(){this.router.navigate(['courses'],{queryParams:{search:this.searchTerm}});}
}