import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Repository } from './repository';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {
  private repositories: Repository[] = [];

  constructor(
    private client: HttpClient
  ) { }

  addRepository(repository: Repository): void {
    this.repositories.push(repository);
  }

  getRepositories(): Observable<Repository[]> {
    return of(this.repositories);
  }
}
