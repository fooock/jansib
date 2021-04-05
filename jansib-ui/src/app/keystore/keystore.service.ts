import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { delay } from 'rxjs/operators';
import { Key } from 'selenium-webdriver';
import { Keystore, SshConfig } from './keystore';

@Injectable({
  providedIn: 'root'
})
export class KeystoreService {
  private keystores: Keystore[] = [];

  constructor(
    private client: HttpClient
  ) {
    const k = new Keystore('1', 'Hetzner servers', 'My short description', 'ssh', new SshConfig('root', '', '', ''));
    this.keystores.push(k);
  }

  addKeystore(keystore: Keystore): Observable<Keystore> {
    keystore.id = Math.random().toString(36).substr(2, 5);
    this.keystores.push(keystore);
    return of(keystore).pipe(delay(1000));
  }

  getKeystores(): Observable<Keystore[]> {
    //const k = new Keystore('12', 'github token', 'dfgsdfgsdfg', 'SSH', new SshConfig('', '', '', ''));
    //this.keystores.push(k);
    return of(this.keystores).pipe(delay(1000));
  }
}
