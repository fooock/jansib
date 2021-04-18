import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  loading: boolean = false;
  loadingKeystore: boolean = false;

  useAuth: boolean = true;
  authValues = [
    { name: 'Yes', value: true },
    { name: 'No', value: false }
  ];

  constructor(
    private service: RepositoryService,
    private ksService: KeystoreService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadingKeystore = true;

    this.ksService.getKeystores().subscribe(args => {
      this.loadingKeystore = false;
      this.keystores = args;
      this.assignDefaultKeystore();

    }, err => {
      console.log(err);
      this.loadingKeystore = false;
    });
  }

  onChange(ks: string): void {
    if (!ks) {
      this.model.keystoreId = '';
      return;
    }
    // assign default keystore if no previously selected
    if (!this.model.keystoreId || this.model.keystoreId.length === 0) {
      this.assignDefaultKeystore();
    }
  }

  createRepository(): void {
    this.loading = true;

    this.service.addRepository(this.model).subscribe(result => {
      this.loading = false;
      this.router.navigate(['repositories']);

    }, err => {
      this.loading = false;
      console.error(err);
    })
  }

  private assignDefaultKeystore(): void {
    // select the first one if available
    if (this.keystores.length > 0) {
      this.model.keystoreId = this.keystores[0].id
    }
  }
}
