import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Keystore } from '../keystore';
import { KeystoreService } from '../keystore.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  model: Keystore = new Keystore('', '', '', '');
  loading: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private service: KeystoreService
  ) { }

  ngOnInit(): void {
    this.loading = true;
    
    this.activatedRoute.params.subscribe(params => {
      this.service.getKeystoreById(params.keyId).subscribe(result => {
        this.loading = false;
        this.model = result;

      }, e => {
        this.loading = false;
      });
    });
  }
}
