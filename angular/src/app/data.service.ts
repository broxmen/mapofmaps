import { Injectable } from '@angular/core';
import { HttpModule, Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class DataService {
  apiRoot: string = "http://localhost:8080/compare";
  constructor(private http: Http) { }

  doPOST(payload: string) {
    let url = `${this.apiRoot}`;
    return this.http.post(url,payload)
      .map(
      response => response.json().items
      )
  }

}
