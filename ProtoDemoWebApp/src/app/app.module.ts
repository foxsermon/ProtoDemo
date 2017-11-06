import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ObservableComponent }  from './observable.component';
import { CatalogService } from './catalog.service';

@NgModule({
  declarations: [
    AppComponent,
    ObservableComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [
    CatalogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
