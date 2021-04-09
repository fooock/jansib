import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Repository } from '../repository';
import { RepositoryService } from '../repository.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  model: Repository = new Repository('', '', '', '', '');
  loading: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private service: RepositoryService
  ) { }

  ngOnInit(): void {
    this.loading = true;
    
    this.activatedRoute.params.subscribe(params => {
      this.service.getRepositoryById(params.repoId).subscribe(result => {
        this.loading = false;
        this.model = result;

      }, e => {
        this.loading = false;
      });
    });
  }
}
