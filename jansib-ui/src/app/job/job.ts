export class Job {
  constructor(
    public id: string,
    public name: string,
    public type: string,
    public repositoryId: string,
    public inventoryId: string,
    public keystoreId: string,
    public created: number
  ) { }
}
