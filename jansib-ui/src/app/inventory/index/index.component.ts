import { Component, OnInit } from '@angular/core';
import { Inventory } from '../inventory';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  inventories: Inventory[] = [];
  loading: boolean = false;

  constructor(
    private service: InventoryService
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.service.getInventories().subscribe(args => {
      this.inventories = args;
      this.loading = false;

    }, err => {
      console.log(err);
      this.loading = false;
    });
  }
}
