export class Keystore {
  constructor(
    public id: string,
    public name: string,
    public description: string,
    public type: string,
    public data?: SshConfig
  ) { }
}

export class SshConfig {
  constructor(
    public username: string,
    public password: string,
    public privateKey: string,
    public passphrase: string
  ) { }
}
