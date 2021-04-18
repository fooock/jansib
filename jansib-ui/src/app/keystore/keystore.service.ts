import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Keystore } from './keystore';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class KeystoreService {
  private apiUrl: string = environment.apiUrl + "/keystore";

  constructor(
    private client: HttpClient
  ) { }

  addKeystore(keystore: Keystore): Observable<Keystore> {
    return this.client.post<Keystore>(this.apiUrl, keystore);
  }

  getKeystores(): Observable<Keystore[]> {
    return this.client.get<Keystore[]>(this.apiUrl);
  }

  getKeystoreById(keyId: string): Observable<Keystore> {
    const u = this.apiUrl + "/" + keyId;
    return this.client.get<Keystore>(u);
  }
}
