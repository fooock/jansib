import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Inventory } from '../inventory';
import { InventoryService } from '../inventory.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  model: Inventory = new Inventory('', '', '', '');
  loading: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private service: InventoryService
  ) { }

  ngOnInit(): void {
    this.loading = true;
    
    this.activatedRoute.params.subscribe(params => {
      this.service.getInventoryById(params.inventoryId).subscribe(result => {
        this.loading = false;
        this.model = result;

      }, e => {
        this.loading = false;
      });
    });
  }
}
