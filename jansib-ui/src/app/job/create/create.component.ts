import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Inventory } from 'src/app/inventory/inventory';
import { InventoryService } from 'src/app/inventory/inventory.service';
import { Keystore } from 'src/app/keystore/keystore';
import { KeystoreService } from 'src/app/keystore/keystore.service';
import { Project } from 'src/app/project/project';
import { ProjectService } from 'src/app/project/project.service';
import { Repository } from 'src/app/repository/repository';
import { RepositoryService } from 'src/app/repository/repository.service';
import { Job } from '../job';
import { JobService } from '../job.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  project: Project = new Project('', '', '', 0);
  keystores: Keystore[] = [];
  inventories: Inventory[] = [];
  repositories: Repository[] = [];

  model: Job = new Job('', '', 'run', '', '', '', 0);

  loading: boolean = false;
  loadingKeystore: boolean = false;
  loadingInventories: boolean = false;
  loadingRepositories: boolean = false;
  loadingProject: boolean = false;

  types = [
    { name: 'Check', id: 'check' },
    { name: 'Run', id: 'run' }
  ];

  constructor(
    private activatedRoute: ActivatedRoute,
    private projectService: ProjectService,
    private keystoreService: KeystoreService,
    private inventoryService: InventoryService,
    private repositoryService: RepositoryService,
    private jobService: JobService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadingKeystore = true;
    this.loadingInventories = true;
    this.loadingRepositories = true;
    this.loadingProject = true;

    this.activatedRoute.params.subscribe(params => {
      this.projectService.getProjectById(params.id).subscribe(result => {
        this.loadingProject = false;
        this.project = result;

      }, err => {
        console.error(err);
        this.loadingProject = false;
      });
    });

    this.keystoreService.getKeystores().subscribe(result => {
      this.loadingKeystore = false;
      this.keystores = result;
      // select default keystore if available
      if (this.keystores.length > 0) {
        this.model.keystoreId = this.keystores[0].id;
      }

    }, err => {
      this.loadingKeystore = false;
    });

    this.inventoryService.getInventories().subscribe(result => {
      this.loadingInventories = false;
      this.inventories = result;
      // select default inventory if available
      if (this.inventories.length > 0) {
        this.model.inventoryId = this.inventories[0].id;
      }

    }, err => {
      this.loadingInventories = false;
    });

    this.repositoryService.getRepositories().subscribe(result => {
      this.loadingRepositories = false;
      this.repositories = result;
      // select default inventory if available
      if (this.repositories.length > 0) {
        this.model.repositoryId = this.repositories[0].id;
      }

    }, err => {
      this.loadingRepositories = false;
    });
  }

  createJob(): void {
    this.loading = true;

    this.jobService.addJob(this.project.id, this.model).subscribe(result => {
      this.loading = false;
      this.router.navigate(['projects', this.project.id]);

    }, err => {
      this.loading = false;
    });
  }
}
