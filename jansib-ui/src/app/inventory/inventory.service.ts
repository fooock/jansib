import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { delay } from 'rxjs/operators';
import { FileConfig, Inventory } from './inventory';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private inventories: Inventory[] = [];

  constructor(
    private client: HttpClient
  ) {
    const i = new Inventory('13213', 'my custom inventory file', 'This is a short description', 'file', 
      new FileConfig('/path/to/my/inventory.ini'));
    this.inventories.push(i);
  }

  addInventory(inventory: Inventory): Observable<Inventory[]> {
    inventory.id = Math.random().toString(36).substr(2, 5);
    this.inventories.push(inventory);
    return of(this.inventories).pipe(delay(1000));
  }

  getInventories(): Observable<Inventory[]> {
    return of(this.inventories).pipe(delay(1000));
  }
}
