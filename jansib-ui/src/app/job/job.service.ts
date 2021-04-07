import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { ProjectService } from '../project/project.service';
import { Job } from './job';

@Injectable({
  providedIn: 'root'
})
export class JobService {
  constructor(
    private client: HttpClient,
    private projectService: ProjectService
  ) { }

  addJob(projectId: string, job: Job): Observable<Job> {
    job.id = Math.random().toString(36).substr(2, 5);
    this.projectService.getProjectById(projectId).subscribe(result => {
      result.jobs.push(job);
    });
    return of(job).pipe(delay(500));
  }

  getJobDetail(projectId: string, jobId: string): Observable<Job> {
    const job = new Job(jobId, 'Update system dependencies', '', '', '', '', 0, 'created');
    return of(job).pipe(delay(500));
  }
}
