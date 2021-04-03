import { Component, OnInit } from '@angular/core';
import { Keystore } from 'src/app/keystore/keystore';
import { KeystoreService } from 'src/app/keystore/keystore.service';
import { Repository } from '../repository';
import { RepositoryService } from '../repository.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  model: Repository = new Repository('', '', '', 'master', '');
  keystores: Keystore[] = [];

  useAuth: boolean = true;
  authValues = [
    { name: 'Yes', value: true },
    { name: 'No', value: false }
  ];

  constructor(
    private service: RepositoryService,
    private ksService: KeystoreService
  ) { }

  ngOnInit(): void {
    this.ksService.getKeystores()
      .subscribe(args => {
        this.keystores = args;
        // select the first one if available
        if (this.keystores.length > 0) {
          this.model.keyId = this.keystores[0].id
        }
      }, err => console.log(err));
  }

  onChange(ks: string): void {
    this.model.keyId = ks;
  }
}
