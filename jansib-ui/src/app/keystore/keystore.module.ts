import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { KeystoreRoutingModule } from './keystore-routing.module';
import { IndexComponent } from './index/index.component';
import { CreateComponent } from './create/create.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    IndexComponent,
    CreateComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    KeystoreRoutingModule
  ]
})
export class KeystoreModule { }
