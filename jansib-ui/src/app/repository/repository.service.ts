import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { Repository } from './repository';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {
  private repositories: Repository[] = [];

  constructor(
    private client: HttpClient
  ) {
    const r1 = new Repository('324234', 'jansib', 'https://github.com/fooock/jansib', 'master', '');
    const r2 = new Repository('324535', 'kubespray', 'https://github.com/kubernetes-sigs/kubespray', 'master', '199798797 dgdfgdg979');
    const r3 = new Repository('636405', 'sdfsfsdf', 'https://docs.ansible.com/ansible-tower/latest/html/userguide/job_templates.html#create-a-job-template', 'v1.4.0', '123434')
    this.repositories.push(r1, r2, r3);
  }

  addRepository(repository: Repository): Observable<Repository[]> {
    repository.id = Math.random().toString(36).substr(2, 5);
    this.repositories.push(repository);
    return of(this.repositories).pipe(delay(1000));
  }

  getRepositories(): Observable<Repository[]> {
    return of(this.repositories).pipe(delay(1000));
  }
}
