import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KeystoreRoutingModule } from './keystore-routing.module';
import { IndexComponent } from './index/index.component';

@NgModule({
  declarations: [IndexComponent],
  imports: [
    CommonModule,
    KeystoreRoutingModule
  ]
})
export class KeystoreModule { }
