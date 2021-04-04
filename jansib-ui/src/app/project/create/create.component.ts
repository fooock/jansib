import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  model: Project = new Project('', '', '', 0);
  loading: boolean = false;

  constructor(
    private service: ProjectService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  createProject(): void {
    this.loading = true;

    this.service.addProject(this.model).subscribe(result => {
      this.loading = false;
      this.router.navigate(['projects', result.id]);

    }, err => {
      console.error(err);
      this.loading = false;
    });
  }
}
