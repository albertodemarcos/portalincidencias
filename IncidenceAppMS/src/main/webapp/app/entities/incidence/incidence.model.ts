
export interface IIncidence {
    
    create(idP: Number, titleP: string, descriptionP: string, startDateP: Date, endDateP: Date,
        longitudeP: Number, latitudeP: Number, resolvedP: Boolean): void;
}


export class Incidence implements IIncidence {

    id?: Number;
    title?: string;
    description?: string; 
    startDate?: Date;
    endDate?: Date;
    longitude?: Number; 
    latitude?: Number;
    resolved?: Boolean; 

    constructor() 
    {  
        //this.id = 0;
        //this.title = '';
        //this.description = '';
        //this.startDate = new Date();
        //this.endDate = new Date();
        //this.longitude = 0;
        //this.latitude = 0;
        //this.resolved = false;
    }

    create(idP: Number, titleP: string, descriptionP: string, startDateP: Date, endDateP: Date, longitudeP: Number, latitudeP: Number, resolvedP: Boolean): void {
        this.id = idP;
        this.title = titleP;
        this.description = descriptionP;
        this.startDate = startDateP;
        this.endDate = endDateP;
        this.longitude = longitudeP;
        this.latitude = latitudeP;
        this.resolved = resolvedP;
    }
}
