import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProjectRoutingModule } from './project-routing.module';
import { IndexComponent } from './index/index.component';
import { CreateComponent } from './create/create.component';
import { FormsModule } from '@angular/forms';
import { ListComponent } from './list/list.component';
import { DetailComponent } from './detail/detail.component';
import { JobModule } from '../job/job.module';

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
    ProjectRoutingModule,
    JobModule
  ]
})
export class ProjectModule { }
