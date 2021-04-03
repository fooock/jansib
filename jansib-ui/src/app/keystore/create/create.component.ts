import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Keystore, SshConfig } from '../keystore';
import { KeystoreService } from '../keystore.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  types: string[] = ['SSH'];
  model: Keystore = new Keystore('', '', '', '');
  loading: boolean = false;

  constructor(
    private service: KeystoreService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.onChange(this.types[0]);
  }

  onChange(type: string): void {
    this.model.type = type;
    if (this.model.type == 'SSH') {
      this.model.ssh = new SshConfig('', '', '', '');
      // default set ssh username to root
      if (this.model.ssh!.username.length === 0)
        this.model.ssh!.username = 'root';
    }
  }

  createKeystore(): void {
    console.log(`Create ks: ${JSON.stringify(this.model)}`);
    this.loading = true;

    this.service.addKeystore(this.model).subscribe(result => {
      this.loading = false;
      this.router.navigate(['keystores']);

    }, e => {
      this.loading = false;
      console.error(e);
    });
  }
}
