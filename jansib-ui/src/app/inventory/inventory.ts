export class Inventory {
  constructor(
    public id: string,
    public name: string,
    public description: string,
    public type: string,
    public data?: FileConfig
  ) { }
}

export class FileConfig {
  constructor(
    public path: string
  ) { }
}
