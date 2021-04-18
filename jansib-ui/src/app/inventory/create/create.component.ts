import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FileConfig, Inventory } from '../inventory';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  model: Inventory = new Inventory('', '', '', '');
  sources = [
    { name: 'File', id: 'file' }
  ];
  loading: boolean = false;

  constructor(
    private service: InventoryService,
    private router: Router
  ) { }

  ngOnInit(): void {
    // assign a default value...
    this.model.type = this.sources[0].id;
    this.model.data = new FileConfig('');
  }

  createInventory(): void {
    this.loading = true;

    this.service.addInventory(this.model).subscribe(result => {
      this.loading = false;
      this.router.navigate(['inventories']);

    }, err => {
      this.loading = false;
    });
  }
}
