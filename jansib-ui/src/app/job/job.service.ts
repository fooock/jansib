import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { ProjectService } from '../project/project.service';
import { Job } from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private apiUrl: string = environment.apiUrl;

  constructor(
    private client: HttpClient
  ) { }

  addJob(projectId: string, job: Job): Observable<Job> {
    return this.client.post<Job>(`${this.apiUrl}/project/${projectId}/job`, job);
  }

  getJobDetail(projectId: string, jobId: string): Observable<Job> {
    return this.client.get<Job>(`${this.apiUrl}/project/${projectId}/job/${jobId}`);
  }
}
