export class reserva {
    id?: number;
    id_user : number;
    fecha : string;
    estado : boolean;
    constructor(id : number, id_user : number,fecha : string , estado : boolean){
        this.id = id;
        this.id_user = id_user;
        this.estado = estado;
        this.fecha = fecha;
    }

}