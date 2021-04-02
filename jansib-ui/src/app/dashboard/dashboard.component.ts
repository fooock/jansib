import { Component, OnInit } from '@angular/core';
import { Project } from '../project/project';
import { ProjectService } from '../project/project.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  projects: Project[] = [];

  constructor(
    private projectService: ProjectService
  ) { }

  ngOnInit(): void {
    this.projectService.getProjects()
    .subscribe(args => this.projects = args, 
      err => console.log(err));
  }
}
