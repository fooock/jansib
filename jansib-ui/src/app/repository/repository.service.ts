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
    const r = new Repository('324', 'erwer', 'asdfsdf', 'master', '1');
    this.repositories.push(r);
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
