import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  model: Project = new Project('', '', '', 0);
  loading: boolean = true;

  constructor(
    private service: ProjectService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.activatedRoute.params.subscribe(params => {
      this.service.getProjectById(params.id).subscribe(project => {
        this.model = project;
        this.loading = false;

      }, err => {
        this.loading = false;
        this.router.navigate(['projects']);
      })
    });
  }
}
