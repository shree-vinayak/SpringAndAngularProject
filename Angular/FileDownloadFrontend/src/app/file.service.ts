import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Http, ResponseContentType } from '@angular/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  constructor(private http: Http) { }

  downloadFile(): Observable<any> {
    return this.http.get('http://localhost:9090/Astute/download/dailyLogSheetPdf?devId=200019&date=23-08-2020', { responseType: ResponseContentType.Blob });
  }
}
