import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inventory } from './inventory';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InventoryService {
  private apiUrl: string = environment.apiUrl + "/inventory";

  constructor(
    private client: HttpClient
  ) { }

  addInventory(inventory: Inventory): Observable<Inventory[]> {
    return this.client.post<Inventory[]>(this.apiUrl, inventory);
  }

  getInventories(): Observable<Inventory[]> {
    return this.client.get<Inventory[]>(this.apiUrl);
  }

  getInventoryById(inventoryId: string): Observable<Inventory> {
    const u = this.apiUrl + "/" + inventoryId;
    return this.client.get<Inventory>(u);
  }
}
