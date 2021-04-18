import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Repository } from './repository';

@Injectable({
  providedIn: 'root'
})
export class RepositoryService {
  private apiUrl: string = environment.apiUrl + "/repository";

  constructor(
    private client: HttpClient
  ) { }

  addRepository(repository: Repository): Observable<Repository[]> {
    return this.client.post<Repository[]>(this.apiUrl, repository);
  }

  getRepositories(): Observable<Repository[]> {
    return this.client.get<Repository[]>(this.apiUrl);
  }

  getRepositoryById(repoId: string): Observable<Repository> {
    const u = this.apiUrl + "/" + repoId;
    return this.client.get<Repository>(u);
  }
}
