export class login {
    correo : string;
    contrasena  : string;
    constructor(correo : string, contrasena : string){
        this.correo = correo;
        this.contrasena = contrasena;
    }
}
export class user {
    id?: number;
    correo : string;
    contrasena  : string;
    nombres : string;
    constructor(correo : string, contrasena : string, nombres : string, id : number){
        this.correo = correo;
        this.contrasena = contrasena;
        this.nombres = nombres;
        this.id = id;
    }
}