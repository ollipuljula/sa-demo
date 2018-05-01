import {IValidationError} from "./validation-error.interface";

export interface IField {
  disabled: boolean;
  fieldType: string;
  name: string;
  type: string;
  value: string;
  visible: boolean;
  validationErrors: IValidationError[];
}
