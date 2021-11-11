import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';

/**
 * @description Componenete consultar comic
 * 
 * @author midc
 */
@Component({
    selector: 'App-ConsultarCompraComic',
    templateUrl: './consultar-CompraComic.html',
    styleUrls: ['./consultar-CompraComic.css']
})
export class ConsultarCompraComicComponent implements OnInit {

    /**
     * Atributo que contendra la informacion del CompraComic
     */
    public CompraComic: any;
    /**
     * Atributo que contiene los controles del formulario
     */
    public consultarCompraComicForm: FormGroup;

    /**
     * @description Este es el constructor del componente
     * @author midc
     */
    constructor(private fb: FormBuilder, private router: Router, private activatedRoute: ActivatedRoute) {
                this.consultarCompraComicForm = this.fb.group({
                    direccion: [null, Validators.required],
                    fechaCreacion : [null, Validators.required],
                    estadoEnum : [null, Validators.required],
                    montoCredito : [null, Validators.required],
                    persona: [null, Validators.required],
                });
    }


    /**
     * @description Evento angular que se ejecuta al invocar el componente
     * @author midc
     */
    ngOnInit(): void {
        this.CompraComic = this.activatedRoute.snapshot.params;
        this.buscarCompraComic();
    }

    /**
     * metodo que se encarga de asignar a la ventana consultar CompraComic los datos de un CompraComic, 
     * ademas desahbilita la edicion de campos
     */
    public buscarCompraComic(): void {
        this.consultarCompraComicForm.controls.direccion.setValue(this.CompraComic.direccion);
        this.consultarCompraComicForm.controls.fechaCreacion.setValue(this.CompraComic.fechaCreacion);
        this.consultarCompraComicForm.controls.estadoEnum.setValue(this.CompraComic.estadoEnum);
        this.consultarCompraComicForm.controls.montoCredito.setValue(this.CompraComic.montoCredito);
        this.consultarCompraComicForm.controls.persona.setValue(this.CompraComic.persona);
        
        this.consultarCompraComicForm.controls.direccion.disable();
        this.consultarCompraComicForm.controls.fechaCreacion.disable();
        this.consultarCompraComicForm.controls.estadoEnum.disable();
        this.consultarCompraComicForm.controls.montoCredito.disable();
        this.consultarCompraComicForm.controls.persona.disable();
    }

    /**
     * metodo que permite regresar al componente de gestionar comic
     */
    public irAtras(): void {
        this.router.navigate(['gestionar-CompraComic']);
    }
}