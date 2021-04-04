import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './project';
import { Observable, of, throwError } from 'rxjs';
import { delay } from 'rxjs/operators';
import { Job } from '../job/job';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  public projects: Project[] = [];

  constructor(private client: HttpClient) {
    const j1 = new Job('1', 'dfgdsfg', 'run', 'asdfa', 'asdfadf', 'adsfadsf', 0);

    const p1 = new Project('123', 'Project 1', '', 1617555292);
    p1.jobs.push(j1);

    const p2 = new Project('345', 'Project 2', 'This is the description of the project 2', 1617555292);
    this.projects.push(p1, p2);
  }

  getProjects(): Observable<Project[]> {
    return of(this.projects).pipe(delay(1000));
  }

  addProject(project: Project): Observable<Project> {
    project.id = Math.random().toString(36).substr(2, 5);
    project.created = Math.floor(Date.now() / 1000);
    this.projects.push(project);
    return of(project).pipe(delay(1000));
  }

  getProjectById(id: string): Observable<Project> {
    for (let index = 0; index < this.projects.length; index++) {
      const p = this.projects[index];
      if (p.id == id) {
        return of(p).pipe(delay(1000));
      }
    }
    return throwError("not found");
  }
}
