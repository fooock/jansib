import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Project } from './project';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProjectService {
  private apiUrl: string = environment.apiUrl + "/project";

  constructor(
    private client: HttpClient
  ) { }

  getProjects(): Observable<Project[]> {
    return this.client.get<Project[]>(this.apiUrl);
  }

  addProject(project: Project): Observable<Project> {
    return this.client.post<Project>(this.apiUrl, project);
  }

  getProjectById(id: string): Observable<Project> {
    const u = this.apiUrl + "/" + id;
    return this.client.get<Project>(u);
  }
}
