import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProjectModule } from './project/project.module';
import { KeystoreModule } from './keystore/keystore.module';
import { InventoryModule } from './inventory/inventory.module';
import { RepositoryModule } from './repository/repository.module';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ProjectModule,
    KeystoreModule,
    InventoryModule,
    RepositoryModule
  ],
  providers: [],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
