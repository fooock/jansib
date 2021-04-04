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
    const p1 = new Project('', 'Project 1', '', 0);
    const p2 = new Project('', 'Project 2', 'This is the description of the project 2', 0);
    this.projects.push(p1, p2);
    return of(this.projects).pipe(delay(100));
  }

  addProject(project: Project): Observable<Project[]> {
    project.id = Math.random().toString(36).substr(2, 5);
    this.projects.push(project);
    return of(this.projects).pipe(delay(1000));
  }
}
