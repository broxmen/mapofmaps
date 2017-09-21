import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { Http, Response, RequestOptions, Headers } from '@angular/http';
// User defined
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { LeftMapComponent } from './leftmap.component';
import { RightMapComponent } from './rightmap.component';
import { CompareComponent } from './compare.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LeftMapComponent,
    RightMapComponent,
    CompareComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
