import { AppError } from "./app-error";

export interface AppResponse {
    codigo : string;
    data? : any;
    responseError? : AppError[],
    mensaje? : string,
    invalidSession? : boolean
}