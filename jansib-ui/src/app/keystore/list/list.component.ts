import { Component, Input, OnInit } from '@angular/core';
import { Keystore } from '../keystore';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  @Input() keystores: Keystore[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  sshTypeExists(): boolean {
    return this.getSshTypes().length > 0;
  }

  getSshTypes(): Keystore[] {
    return this.keystores.filter(k => k.type === 'ssh');
  }
}
