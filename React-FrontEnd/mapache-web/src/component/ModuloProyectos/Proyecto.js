import React, {Component} from "react";
import {Button, Card, Form} from "react-bootstrap";
import axios from "axios";

export default class Proyecto extends Component {
    constructor(props) {
        super(props);
        this.state = this.estadoInicial;
        this.crearProyecto = this.crearProyecto.bind(this);
        this.cambioProyecto = this.cambioProyecto.bind(this);
    }

    estadoInicial = {id:'', nombre:'', tipo:''};

    crearProyecto = event => {
        event.preventDefault();
        const proyecto = {
            id: this.state.id,
            nombre: this.state.nombre,
            tipoDeProyecto: this.state.tipo
        };

        axios.post("http://localhost:8080/proyectos", proyecto)
            .then(respuesta=> {
                if(respuesta.data != null){
                    this.setState(this.estadoInicial);
                    alert("El proyecto se creo exitosamente");
                }
            })
    }

    cambioProyecto = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render() {
        const {id, nombre, tipo} = this.state;
        return(
            <div className={"proyectoDiv"}>
                <Card className={"proyecto-card"}>
                    <Form id="formularioProyecto" onSubmit={this.crearProyecto}>
                        <Card.Header>Agregar proyecto</Card.Header>
                        <Card.Body>
                                <Form.Group controlId="formGridID">
                                    <Form.Label>ID</Form.Label>
                                    <Form.Control
                                        required autoComplete="off"
                                        type="text" name="id"
                                        value={id}
                                        onChange={this.cambioProyecto}
                                    />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Nombre</Form.Label>
                                    <Form.Control
                                        required autoComplete="off"
                                        type="text" name="nombre"
                                        value={nombre}
                                        onChange={this.cambioProyecto}
                                    />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Tipo de proyecto</Form.Label>
                                    <Form.Control
                                        required autoComplete="off"
                                        type="text" name="tipo"
                                        value={tipo}
                                        onChange={this.cambioProyecto}
                                        placeholder="Implementación o Desarrollo"
                                    />
                                </Form.Group>
                        </Card.Body>
                        <Card.Footer>
                            <Button variant="success" type="submit">
                                Crear Proyecto
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}