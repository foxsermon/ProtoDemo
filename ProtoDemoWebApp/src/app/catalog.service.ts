import {Injectable} from '@angular/core';
import {Http, Response, Headers, RequestOptions} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';

import {Catalog} from './catalog';
import {Observable} from 'rxjs';

@Injectable()
export class CatalogService {
  // url = 'http://localhost:4200/assets/data/books.json';
  url = 'http://127.0.0.1:8080/protoCatalog/rest/catalogs';
  constructor(private http: Http) {}

  getCatalogsWithObservable(): Observable<Catalog[]> {
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this.http.get(this.url, options)
      .map(this.extractData)
      .catch(this.handleErrorObservable);
  }

  private extractData(res: Response) {
    const body = res.json();
    return body;
  }

  private handleErrorObservable(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.message || error);
  }

}
