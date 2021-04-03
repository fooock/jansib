export class Repository {
  constructor(
    public id: string,
    public name: string,
    public url: string,
    public branch: string = 'master',
    public keyId: string
  ) { }
}
