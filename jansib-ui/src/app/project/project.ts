import { Job } from "../job/job";

export class Project {
  constructor(
    public id: string,
    public name: string,
    public description: string,
    public created: number,
    public jobs: Job[] = []
  ) { }

  formattedDate(): string {
    const d = new Date(this.created * 1000);
    return d.toLocaleDateString();
  }
}
