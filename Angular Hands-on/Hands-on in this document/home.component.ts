import { Component, OnDestroy, OnInit } from '@angular/core'; import { FormsModule } from '@angular/forms';
@Component({standalone:true,imports:[FormsModule],template:`<div class="container"><h1>{{portalName}}</h1><p>Browse courses, enroll, view your profile and grades.</p><div class="grid"><b>Courses Available: {{courseCount}}</b><b>Enrolled: 3</b><b>GPA: 3.8</b></div><p><input [(ngModel)]="searchTerm" placeholder="Search"><span> Searching for: {{searchTerm}}</span></p><button [disabled]="!isPortalActive" (click)="onEnrollClick()">Enroll Now</button><p>{{message}}</p></div>`})
export class HomeComponent implements OnInit,OnDestroy {
 portalName='Student Course Portal'; isPortalActive=true; searchTerm=''; message=''; courseCount=12;
 // [property] is one-way component -> DOM; [(ngModel)] is two-way DOM <-> component.
 onEnrollClick(){this.message='Enrollment opened!';}
 ngOnInit(){console.log('HomeComponent initialised — courses loaded');}
 ngOnDestroy(){console.log('HomeComponent destroyed');}
}