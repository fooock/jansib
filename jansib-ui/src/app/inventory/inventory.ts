export class Inventory {
  constructor(
    public id: string,
    public name: string,
    public description: string,
    public source: string,
    public fileConfig?: FileConfig
  ) { }
}

export class FileConfig {
  constructor(
    public path: string
  ) { }
}
