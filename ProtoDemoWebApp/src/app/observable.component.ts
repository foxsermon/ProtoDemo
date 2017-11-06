import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';

import {CatalogService} from './catalog.service';
import {Catalog} from './catalog';

@Component({
  selector: 'app-observable',
  templateUrl: 'observable.component.html'
})
export class ObservableComponent implements OnInit {
  observableCatalogs: Observable<Catalog[]>;
  catalogs: Catalog[];
  errorMessage: String;
  constructor(private catalogService: CatalogService) {}
  ngOnInit(): void {
    this.observableCatalogs = this.catalogService.getCatalogsWithObservable();
    this.observableCatalogs.subscribe(
      catalogs => this.catalogs = catalogs,
      error => this.errorMessage = <any>error);
  }
}
