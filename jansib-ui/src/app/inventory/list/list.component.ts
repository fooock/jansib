import { Component, Input, OnInit } from '@angular/core';
import { Inventory } from '../inventory';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  @Input() inventories: Inventory[] = [];

  constructor(
    private service: InventoryService
  ) { }

  ngOnInit(): void {
  }
}
