import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateComponent } from './create/create.component';
import { DetailComponent } from './detail/detail.component';
import { IndexComponent } from './index/index.component';

const routes: Routes = [
  {
    path: '',
    component: IndexComponent
  },
  {
    path: 'create',
    component: CreateComponent
  },
  {
    path: ':repoId',
    component: DetailComponent
  }
];

@NgModule({
  exports: [
    RouterModule
  ],
  imports: [
    RouterModule.forChild(routes)
  ]
})
export class RepositoryRoutingModule { }
