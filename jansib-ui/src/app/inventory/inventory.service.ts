import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { Inventory } from './inventory';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private inventories: Inventory[] = [];

  constructor(
    private client: HttpClient
  ) { }

  addInventory(inventory: Inventory): void {
    this.inventories.push(inventory);
  }

  getInventories(): Observable<Inventory[]> {
    return of(this.inventories);
  }
}
