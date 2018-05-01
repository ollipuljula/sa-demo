import {IField} from "./field.interface";

export interface ISection {
  id: number;
  name: string;
  fields: IField[];
}
