import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Keystore } from './keystore';

@Injectable({
  providedIn: 'root'
})
export class KeystoreService {
  private keystores: Keystore[] = [];

  constructor(
    private client: HttpClient
  ) { }

  addKeystore(keystore: Keystore): void {
    this.keystores.push(keystore);
  }

  getKeystores(): Observable<Keystore[]> {
    return of(this.keystores);
  }
}
