import { Component, OnInit } from '@angular/core';
import { HttpModule, Http, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import { DataService } from "./data.service";
import { Observable } from 'rxjs/Rx';

@Component({
  selector: 'my-app',
  templateUrl: './compare.component.html',
  providers: [DataService]
})
export class CompareComponent implements OnInit {
  title = 'Comparison Results';
  Maps;
  response;
  payload = {};
  op: string;
  apiRoot: string = "http://localhost:8080/compare";

  constructor(private http: Http, private dataservice: DataService) {
  }

  ngOnInit(): void {
    this.payload['left'] = JSON.parse(localStorage.left);
    this.payload['right'] = JSON.parse(localStorage.right);
    this.op = JSON.stringify(this.payload);
    this.callforPOST(this.op);
  }

  callforPOST(payload) {
    this.dataservice.doPOST(this.op)
      .subscribe(
      res => this.response = res,
      error => alert(error),
      () => console.log('Finished')
      )
    console.log(this.response)
  }
}