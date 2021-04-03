import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Keystore, SshConfig } from './keystore';

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
    //const k = new Keystore('12', 'github token', 'dfgsdfgsdfg', 'SSH', new SshConfig('', '', '', ''));
    //this.keystores.push(k);
    return of(this.keystores);
  }
}
