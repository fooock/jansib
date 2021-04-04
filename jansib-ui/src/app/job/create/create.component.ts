import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Project } from 'src/app/project/project';
import { ProjectService } from 'src/app/project/project.service';
import { Job } from '../job';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  project: Project = new Project('', '', '', 0);
  model: Job = new Job('', '', '', '', '', '', 0);
  loading: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private projectService: ProjectService
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.activatedRoute.params.subscribe(params => {
      this.projectService.getProjectById(params.id).subscribe(result => {
        this.loading = false;
        this.project = result;

      }, err => {
        console.error(err);
        this.loading = false;
      });
    });
  }

  createJob(): void {

  }
}
