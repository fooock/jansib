import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Job } from '../job';
import { JobService } from '../job.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  model: Job = new Job('', '', '', '', '', '', 0, '');
  projectId: string = '';
  loading: boolean = false;

  constructor(
    private activatedRoute: ActivatedRoute,
    private service: JobService
  ) { }

  ngOnInit(): void {
    this.loading = true;

    this.activatedRoute.params.subscribe(args => {
      this.projectId = args.id;
      this.service.getJobDetail(args.id, args.jobId).subscribe(result => {
        this.model = result;
        this.loading = false;
        
      }, e => {
        this.loading = false;
      })
    });
  }
}
