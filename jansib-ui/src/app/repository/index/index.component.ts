import { Component, OnInit } from '@angular/core';
import { Repository } from '../repository';
import { RepositoryService } from '../repository.service';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  repositories: Repository[] = [];

  constructor(
    private service: RepositoryService
  ) { }

  ngOnInit(): void {
    this.service.getRepositories()
      .subscribe(args => this.repositories = args,
        err => console.log(err));
  }
}
