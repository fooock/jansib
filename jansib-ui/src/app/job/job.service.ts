import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CreateJob, Job } from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  private apiUrl: string = environment.apiUrl;

  constructor(
    private client: HttpClient
  ) { }

  addJob(projectId: string, job: CreateJob): Observable<Job> {
    return this.client.post<Job>(`${this.apiUrl}/project/${projectId}/job`, job);
  }

  getJobDetail(projectId: string, jobId: string): Observable<Job> {
    return this.client.get<Job>(`${this.apiUrl}/project/${projectId}/job/${jobId}`);
  }
}
