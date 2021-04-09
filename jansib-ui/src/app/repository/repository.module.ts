import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IndexComponent } from './index/index.component';
import { RepositoryRoutingModule } from './repository-routing.module';
import { CreateComponent } from './create/create.component';
import { FormsModule } from '@angular/forms';
import { ListComponent } from './list/list.component';
import { DetailComponent } from './detail/detail.component';

@NgModule({
  declarations: [
    IndexComponent,
    CreateComponent,
    ListComponent,
    DetailComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    RepositoryRoutingModule
  ]
})
export class RepositoryModule { }
