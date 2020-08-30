import { FileService } from './file.service';
import * as fileSaver from 'file-saver';
import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'FileDownloadFrontend';

  constructor(private fileService: FileService) { }


  download() {
    this.fileService.downloadFile().subscribe(response => {
      let blob: any = new Blob([response.blob()], { type: 'application/pdf; charset=utf-8' });
      console.log(blob)
      var headers = response.headers;
      var filename = headers.get('Pragma');
      console.log(filename)


      fileSaver.saveAs(blob, filename);

    }), error => console.log('Error downloading the file'),
      () => console.info('File downloaded successfully');
  }


  // @ViewChild('htmlData') htmlData:ElementRef;

  // USERS = [
  //   {
  //     "id": 1,
  //     "name": "Leanne Graham",
  //     "email": "sincere@april.biz",
  //     "phone": "1-770-736-8031 x56442"
  //   },
  //   {
  //     "id": 2,
  //     "name": "Ervin Howell",
  //     "email": "shanna@melissa.tv",
  //     "phone": "010-692-6593 x09125"
  //   },
  //   {
  //     "id": 3,
  //     "name": "Clementine Bauch",
  //     "email": "nathan@yesenia.net",
  //     "phone": "1-463-123-4447",
  //   },
  //   {
  //     "id": 4,
  //     "name": "Patricia Lebsack",
  //     "email": "julianne@kory.org",
  //     "phone": "493-170-9623 x156"
  //   },
  //   {
  //     "id": 5,
  //     "name": "Chelsey Dietrich",
  //     "email": "lucio@annie.ca",
  //     "phone": "(254)954-1289"
  //   },
  //   {
  //     "id": 6,
  //     "name": "Mrs. Dennis",
  //     "email": "karley@jasper.info",
  //     "phone": "1-477-935-8478 x6430"
  //   }
  // ];

  // constructor() { }

  // public openPDF():void {
  //   let DATA = this.htmlData.nativeElement;
  //   let doc = new jsPDF('p','pt', 'a4');
  //   doc.fromHTML(DATA.innerHTML,15,15);
  //   doc.output('dataurlnewwindow');
  // }


  // public downloadPDF():void {
  //   let DATA = this.htmlData.nativeElement;
  //   let doc = new jsPDF('p','pt', 'a4');

  //   let handleElement = {
  //     '#editor':function(element,renderer){
  //       return true;
  //     }
  //   };
  //   doc.fromHTML(DATA.innerHTML,15,15,{
  //     'width': 200,
  //     'elementHandlers': handleElement
  //   });

  //   doc.save('angular-demo.pdf');
  // }

  // generatePdf(){
  //   const documentDefinition = { content: 'This is an sample PDF printed with pdfMake' };
  //   pdfMake.createPdf(documentDefinition).download();
  //  }

//   title = 'html-to-pdf-angular-application';
// public convetToPDF()
// {
// var data = document.getElementById('contentToConvert');
// html2canvas(data).then(canvas => {
// // Few necessary setting options
// var imgWidth = 208;
// var pageHeight = 295;
// var imgHeight = canvas.height * imgWidth / canvas.width;
// var heightLeft = imgHeight;
 
// const contentDataURL = canvas.toDataURL('image/png')
// let pdf = new jspdf('p', 'mm', 'a4'); // A4 size page of PDF
// var position = 0;
// pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
// pdf.save('new-file.pdf'); // Generated PDF
// });
// }

// title = 'html-to-pdf';
// generatePDF() {
//   var data = document.getElementById('contentToConvert');
//   html2canvas(data).then(canvas => {
//     var imgWidth = 208;
//     var imgHeight = canvas.height * imgWidth / canvas.width;
//     const contentDataURL = canvas.toDataURL('image/png')
//     let pdf = new jspdf('p', 'mm', 'a4');
//     var position = 0;
//     pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)
//     pdf.save('newPDF.pdf');
//   });
// }

  
}
