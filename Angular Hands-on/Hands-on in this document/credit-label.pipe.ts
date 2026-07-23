import { Pipe, PipeTransform } from '@angular/core';
@Pipe({name:'creditLabel', standalone:true})
export class CreditLabelPipe implements PipeTransform {
  transform(value:number|null|undefined):string {
    if (!value) return 'No Credits';
    return `${value} ${value===1?'Credit':'Credits'}`;
  }
}