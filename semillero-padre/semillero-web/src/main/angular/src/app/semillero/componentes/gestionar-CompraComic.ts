import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { GestionarCompraComicService } from '../../servicios/gestionar.CompraComic.service';
import { CompraComicDTO } from '../../dto/CompraComicDto';


/**
 * @description Componenete gestionar comic, el cual contiene la logica CRUD
 * 
 * @author midc
 */
@Component({
    selector: 'gestionar-CompraComic',
    templateUrl: './gestionar-CompraComic.html',
    styleUrls: ['./gestionar-CompraComic.css']
})
export class GestionarCompraComicComponent implements OnInit {

    /**
     * Atributo que contiene los controles del formulario
     */
    public gestionarCompraComicForm : FormGroup;

    /**
     * Atributo que contendra la informacion del comic
     */
    public CompraComic: CompraComicDTO;

    /**
     * Atributo que contendra la lista de comics creados
     */
    public listaCompraComices : Array<CompraComicDTO>;

    /**
     * atributo para saber si se va a editar una entidad
     */
    public isEdit: boolean;

    /**
     * atributo para guardar el id del comic a modificar
     */
    public idModificar: string;

    public nombreP: string;

    /**
     * Atributo que indica si se envio a validar el formulario
     */
    public submitted : boolean;

    /**
     * @description Este es el constructor del componente GestionarComicComponent
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    constructor(private fb : FormBuilder,
        private router : Router,
        private gestionarCompraComicService : GestionarCompraComicService) {
        this.gestionarCompraComicForm = this.fb.group({
            direccion: [null, Validators.required],
            fechaCreacion : [null, Validators.required],
            estadoEnum : [null, Validators.required],
            montoCredito : [null, Validators.required],
            persona: [null, Validators.required],
            idPersona: [null, Validators.required],
        });
    }

    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    ngOnInit(): void {
        console.log("Ingreso al al evento oninit");
        this.CompraComic = new CompraComicDTO();
        this.listaCompraComices = new Array<CompraComicDTO>();
        this.consultarCompraComic();
        this.isEdit = false;
    }

    /**
     * @description Metodo encargado de consultar los comics existentes
     * @author Diego Fernando Alvarez Silva <dalvarez@heinsohn.com.co>
     */
    public consultarCompraComic() : void {
        this.gestionarCompraComicService.consultarCompraComices().subscribe( listaCompraComices => {
           this.listaCompraComices = listaCompraComices;
        }, error => {
            console.log(error);
        });
    }

    public modificarDireccionCompraComic(id: number, direccion: string): void{
        this.gestionarCompraComicService.addDireccionCompraComic(direccion, id).subscribe(resultDto => {
            if(resultDto.exitoso){
                this.consultarCompraComic();
            }
        }, error => {
            console.log(error);
        });
    }

    /**
     * @description Metodo encargado de crear/modificar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    
    public crearActualizarCompraComic(): void {
        this.submitted = true;
        if(this.gestionarCompraComicForm.invalid) {
            return;
        }
        if(!this.isEdit){
            this.crearCompraComic();
        this.gestionarCompraComicService.crearCompraComic(this.CompraComic, this.idModificar).subscribe( resultDTO => {
             if(resultDTO.exitoso){
                 this.consultarCompraComic();
                 this.limpiarFormulario();
                }
            }, error => {
                console.log(error);
            });
        } else {
            this.crearCompraComic();
            this.gestionarCompraComicService.modiicarCompraComic(this.CompraComic.montoCredito, "hola", this.CompraComic.id).subscribe( resultDTO => {
                if(resultDTO.exitoso){
                    this.consultarCompraComic();
                    this.limpiarFormulario();
                    this.isEdit = false;
                   }
               }, error => {
                   console.log(error);
               });
        }
    }

    /**
     * @description Metodo encargado de crear un comic con los datos del formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    
    public crearCompraComic(): void{
        this.CompraComic = new CompraComicDTO();
        this.CompraComic.direccion = this.gestionarCompraComicForm.controls.direccion.value;
        this.CompraComic.fechaCreacion = this.gestionarCompraComicForm.controls.fechaCreacion.value;
        this.CompraComic.estadoEnum = this.gestionarCompraComicForm.controls.estadoEnum.value;
        this.CompraComic.montoCredito = this.gestionarCompraComicForm.controls.montoCredito.value;
        this.idModificar = this.gestionarCompraComicForm.controls.idPersona.value;
        this.nombreP = this.gestionarCompraComicForm.controls.persona.value;
    }

    /**
     * @description Metodo encargado de agregarle los valores de un comic al formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param comic 
     */
    
    public editarCompraComic(CompraComicc: CompraComicDTO): void {
        this.isEdit = true; //bandera para saber si se edito un comic
        this.gestionarCompraComicForm.controls.direccion.setValue(CompraComicc.direccion);
        this.gestionarCompraComicForm.controls.fechaCreacion.setValue(CompraComicc.fechaCreacion);
        this.gestionarCompraComicForm.controls.montoCredito.setValue(CompraComicc.montoCredito);
        this.gestionarCompraComicForm.controls.estadoEnum.setValue(CompraComicc.estadoEnum);
        this.idModificar = CompraComicc.id;
    }
    
    /**
     * @description Metodo encargado de setear los valores del formulario
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    public limpiarFormulario() : void {
        this.submitted = false;
        this.gestionarCompraComicForm.controls.direccion.setValue(null);
        this.gestionarCompraComicForm.controls.fechaCreacion.setValue(null);
        this.gestionarCompraComicForm.controls.estadoEnum.setValue(null);
        this.gestionarCompraComicForm.controls.montoCredito.setValue(null);
        this.gestionarCompraComicForm.controls.persona.setValue(null);
        this.gestionarCompraComicForm.controls.idpersona.setValue(null);
        
    }

    /**
     * 
     * @description Metodo encargado de eliminar un ocmic
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     */
    
    public eliminarComic(idPro: number): void {
        /*
        this.gestionarComicService.eliminarComic(idComic).subscribe(resultadoDTO => {
            if (resultadoDTO.exitoso) {
                this.consultarComics();
            }
        }, error => {
            console.log(error);
        });*/
    }

    /**
     * @description Metodo encargado de consultar un comic mostrandolos en otro componente
     * @author Walter Mauricio Cuervo Barahona <walter.cuervo@uptc.edu.co>
     * @param id 
     */
    
    public consultarComic(id: number): void {
        this.gestionarCompraComicService.consultarCompraComic(id).subscribe(CompraComicDTO => {
            this.router.navigate(['consultar-CompraComic', CompraComicDTO]);
        }, error => {
            console.log(error);
        });
   }

    /**
     * @description Metodo que obtiene los controles y sus propiedades
     * @author Diego Fernando Alvarez Silva
     */
    get f() { 
        return this.gestionarCompraComicForm.controls;
    }
}