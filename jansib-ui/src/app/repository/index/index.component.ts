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
  loading: boolean = false;

  constructor(
    private service: RepositoryService
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.service.getRepositories().subscribe(args => {
      this.repositories = args;
      this.loading = false;

    }, err => {
      console.log(err);
      this.loading = false;
    });
  }
}
