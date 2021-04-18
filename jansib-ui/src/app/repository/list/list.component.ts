import { Component, Input, OnInit } from '@angular/core';
import { Repository } from '../repository';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  @Input() repositories: Repository[] = [];

  constructor() { }

  ngOnInit(): void {
  }

  showType(keystoreId: string): string {
    if (!keystoreId) return "Public";
    return keystoreId.length > 0 ? "Private" : "Public";
  }
}
