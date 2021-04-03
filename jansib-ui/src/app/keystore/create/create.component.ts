import { Component, OnInit } from '@angular/core';
import { Keystore, SshConfig } from '../keystore';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  types: string[] = ['SSH'];
  model: Keystore = new Keystore('', '', '', this.types[0]);

  constructor() { }

  ngOnInit(): void {
  }

  onChange(type: string): void {
    this.model.type = type;
    if (this.model.type == 'SSH') {
      this.model.ssh = new SshConfig('', '', '', '');
    }
  }
}
