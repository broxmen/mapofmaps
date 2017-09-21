import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'left-app',
  templateUrl: 'leftmap.component.html'
})

export class LeftMapComponent implements OnInit {
  count;
  subcount;
  numbers = [];
  subnumbers = [];
  left = { 'maincount': 0 };
  test = [];
  constructor(
    private route: ActivatedRoute,
    private location: Location
  ) { }

  expand(subcount): void {
    this.subcount = subcount;
    for (var i = 1; i <= this.subcount; i++) {
      this.subnumbers.push(i);
    }
  }

  save(): void {

    for (var i = 1; i <= this.count; i++) {
      var mainmap = 'map' + i;
      this.left[mainmap] = {};
      for (var j = 1; j <= this.subcount; j++) {
        var mapper = (<HTMLInputElement>document.getElementById(mainmap.toString())).value;
        var submap = 'submap' + i;
        var submapkey = submap + '_key' + j;
        var submapvalue = submap + '_value' + j;
        var key = (<HTMLInputElement>document.getElementById(submapkey.toString())).value;
        var value = (<HTMLInputElement>document.getElementById(submapvalue.toString())).value;
        this.left[mainmap][key] = value;
      }
      this.test = [];
    }
    localStorage.setItem('left', JSON.stringify(this.left));
    alert('Left map saved');    
  }

  ngOnInit(): void {
    this.count = parseInt(this.route.snapshot.params['count']);
    this.left.maincount = this.count;
    var map;
    for (var i = 1; i <= this.count; i++) {
      this.numbers.push(i);
    }
  }
}