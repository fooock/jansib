import { Component, OnInit } from '@angular/core';
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

  constructor(
    private service: InventoryService
  ) { }

  ngOnInit(): void {
    // assign a default value...
    this.model.source = this.sources[0].id;
    this.model.fileConfig = new FileConfig('');
  }
}
