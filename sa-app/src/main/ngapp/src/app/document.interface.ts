import {ISection} from "./section.interface";

export interface IDocument {
  id: number;
  name: string;
  sections: ISection[];
}
