import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'home-app',
    templateUrl: 'home.component.html'
})

export class HomeComponent { 
    resetmaps(){
        localStorage.removeItem('left');
        localStorage.removeItem('right');
    }
 }