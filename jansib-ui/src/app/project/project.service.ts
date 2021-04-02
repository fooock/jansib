import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './project';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private projects: Project[] = [];

  constructor(private client: HttpClient) { }

  getProjects(): Observable<Project[]> {
    return of(this.projects);
  }

  addProject(project: Project): void {
    this.projects.push(project);
  }
}
