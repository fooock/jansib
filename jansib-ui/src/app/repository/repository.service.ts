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
    const r1 = new Repository('324234', 'Jansib', 'https://github.com/fooock/jansib', 'master', '');
    const r2 = new Repository('324535', 'Kubespray', 'https://github.com/kubernetes-sigs/kubespray', 'main', 'nE9zTbN3Hp');
    const r3 = new Repository('636405', 'ContainerSSH', 'https://docs.ansible.com/ansible-tower/latest/html/userguide/job_templates.html#create-a-job-template', 'v1.4.0', '1wqpbA6Goc')
    this.repositories.push(r1, r2, r3);
  }

  addRepository(repository: Repository): Observable<Repository[]> {
    repository.id = Math.random().toString(36).substr(2, 5);
    this.repositories.push(repository);
    return of(this.repositories).pipe(delay(500));
  }

  getRepositories(): Observable<Repository[]> {
    return of(this.repositories).pipe(delay(500));
  }

  getRepositoryById(repoId: string): Observable<Repository> {
    const repo = this.repositories.filter(r => r.id === repoId)[0];
    return of(repo).pipe(delay(300));
  }
}
