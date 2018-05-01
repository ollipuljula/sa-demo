import { Component } from '@angular/core';
import {DocumentService} from "./document.service";
import {IDocument} from "./document.interface";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  doc: IDocument;

  constructor(private documentService: DocumentService) {
    this.documentService.getDocument(1)
      .subscribe(data => {
        console.log(data);
        this.doc = data;
      });
  }

}
