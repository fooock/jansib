import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { InventoryRountingModule } from './inventory-rounting.module';
import { IndexComponent } from './index/index.component';

@NgModule({
  declarations: [
    IndexComponent
  ],
  imports: [
    CommonModule,
    InventoryRountingModule
  ]
})
export class InventoryModule { }
