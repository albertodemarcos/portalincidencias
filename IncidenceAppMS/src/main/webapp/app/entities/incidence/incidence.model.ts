
export interface IIncidence {
    
    create(idP: number, titleP: string, descriptionP: string, startDateP: Date, endDateP: Date,
        longitudeP: number, latitudeP: number, resolvedP: boolean): void;
}


export class Incidence implements IIncidence {

    id?: number;
    title?: string;
    description?: string; 
    startDate?: Date;
    endDate?: Date;
    longitude?: number; 
    latitude?: number;
    resolved?: boolean; 

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

    create(idP: number, titleP: string, descriptionP: string, startDateP: Date, endDateP: Date, longitudeP: number, latitudeP: number, resolvedP: boolean): void {
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
