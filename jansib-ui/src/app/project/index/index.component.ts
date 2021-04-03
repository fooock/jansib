import { Component, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  projects: Project[] = [];
  loading: boolean = false;

  constructor(
    private projectService: ProjectService
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.projectService.getProjects().subscribe(_ => {
      this.loading = false;
    }, err => {
      this.loading = false;
    });
  }
}
