import { Component, OnInit } from '@angular/core';
import { Keystore } from '../keystore';
import { KeystoreService } from '../keystore.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  keystores: Keystore[] = [];

  constructor(
    private service: KeystoreService
  ) { }

  ngOnInit(): void {
    this.service.getKeystores()
      .subscribe(args => this.keystores = args,
        err => console.log(err));
  }
}
