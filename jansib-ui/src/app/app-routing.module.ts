import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'projects',
    pathMatch: 'full'
  },
  {
    path: 'projects',
    loadChildren: './project/project.module#ProjectModule'
  },
  {
    path: 'keystores',
    loadChildren: './keystore/keystore.module#KeystoreModule'
  },
  {
    path: 'inventories',
    loadChildren: './inventory/inventory.module#InventoryModule'
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
