import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { JobRoutingModule } from './job-routing.module';
import { CreateComponent } from './create/create.component';
import { FormsModule } from '@angular/forms';
import { DetailComponent } from './detail/detail.component';

@NgModule({
  declarations: [CreateComponent, DetailComponent],
  imports: [
    CommonModule,
    FormsModule,
    JobRoutingModule
  ]
})
export class JobModule { }
