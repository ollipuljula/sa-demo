import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {IDocument} from "./document.interface";

@Injectable()
export class DocumentService {

  private baseUrl: string = 'http://localhost:8080/api';
  private documentUrl: string = this.baseUrl + '/document';

  constructor(private http: HttpClient) {
  }

  getDocument(id: number): Observable<IDocument> {
    return this.http.get<IDocument>(this.documentUrl + '/' + id);
  }

}
