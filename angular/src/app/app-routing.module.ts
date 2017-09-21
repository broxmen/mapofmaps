import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { LeftMapComponent } from './leftmap.component';
import { RightMapComponent } from './rightmap.component';
import { CompareComponent } from './compare.component';


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'rightmap/:count', component: RightMapComponent },
  { path: 'leftmap/:count', component: LeftMapComponent },
  { path: 'compare', component: CompareComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }