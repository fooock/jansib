import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './project';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private projects: Project[] = [];

  constructor(private client: HttpClient) { }

  getProjects(): Observable<Project[]> {
    return of(this.projects).pipe(delay(1000));
  }

  addProject(project: Project): Observable<Project[]> {
    this.projects.push(project);
    return of(this.projects).pipe(delay(1000));
  }
}
