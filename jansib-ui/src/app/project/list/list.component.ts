import { Component, Input, OnInit } from '@angular/core';
import { Project } from '../project';
import { ProjectService } from '../project.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  @Input() projects: Project[] = [];

  constructor(
    private service: ProjectService
  ) { }

  ngOnInit(): void {
  }
}
