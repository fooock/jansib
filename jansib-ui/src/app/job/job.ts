import { Inventory } from "../inventory/inventory";
import { Keystore } from "../keystore/keystore";
import { Repository } from "../repository/repository";

export class Job {
  public id: string = '';
  public name: string = '';
  public type: string = '';
  public repository: Repository | undefined;
  public inventory: Inventory | undefined;
  public keystore: Keystore | undefined;
  public created: number = 0;
  public state: string = '';
}

export class CreateJob {
  public name: string = '';
  public type: string = '';
  public repositoryId: string = '';
  public inventoryId: string = '';
  public keystoreId: string = '';
}
