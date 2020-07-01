import React, {Component} from "react";
import { withRouter } from 'react-router';
import {Button, Card, Form} from "react-bootstrap";
import axios from "axios";

class Proyecto extends Component {
    constructor(props) {
        super(props);
        this.state = this.estadoInicial;
        this.crearProyecto = this.crearProyecto.bind(this);
        this.cambioProyecto = this.cambioProyecto.bind(this);
    }

    estadoInicial = {id:'', nombre:'', tipo:"Implementación"};

    crearProyecto = event => {
        event.preventDefault();
        const proyecto = {
            nombre: this.state.nombre,
            tipoDeProyecto: this.state.tipo
        };
        axios.post("http://localhost:8080/proyectos", proyecto)
            .then(respuesta=> {
                if(respuesta.data != null){
                    this.setState(this.estadoInicial);
                    alert("El proyecto se creo exitosamente");
                } else {
                    alert("El proyecto no pudo ser creado");
                }
            })
    }

    cambioProyecto = event => {
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    componentDidMount() {
        const proyectoId = +this.props.match.params.id;
        if(proyectoId){
            axios.get("http://localhost:8080/proyectos/"+proyectoId)
                .then(respuesta => {
                    if(respuesta.data != null){
                        this.setState({
                            id: respuesta.data.id,
                            nombre: respuesta.data.nombre,
                            tipo: respuesta.data.tipoDeProyecto
                        });
                    }
                }).catch((error) => {
                    console.error("Error - "+error);
            });
        }
    }

    actualizarProyecto = event => {
        event.preventDefault();
        const proyecto = {
            id: this.state.id,
            nombre: this.state.nombre,
            tipoDeProyecto: this.state.tipo
        };
        axios.put("http://localhost:8080/proyectos/"+proyecto.id, proyecto)
            .then(respuesta=> {
                if(respuesta.data != null){
                    this.setState(this.estadoInicial);
                    alert("El proyecto: " + proyecto.id+ " se actualizo exitosamente");
                } else {
                    alert("El proyecto no pudo ser actualizado");
                }
            })
    };

    render() {
        const {nombre, tipo} = this.state;
        return(
            <div className={"proyectoDiv"}>
                <Card className={"proyecto-card"}>
                    <Form id="formularioProyecto" onSubmit={this.state.id ? this.actualizarProyecto : this.crearProyecto}>
                        <Card.Header>Agregar proyecto</Card.Header>
                        <Card.Body>
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
                                    <Form.Control as="select" custom
                                                  value={tipo}
                                                  onChange={this.cambioProyecto}
                                                  required autoComplete="off"
                                                  type="text" name="tipo"
                                    >
                                        <option value="Implementación">Implementación</option>
                                        <option value="Desarrollo">Desarrollo</option>
                                    </Form.Control>
                                </Form.Group>
                        </Card.Body>
                        <Card.Footer>
                            <Button variant="success" type="submit">
                                {this.state.id ? "Actualizar" : "Crear Proyecto"}
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}

export default withRouter(Proyecto);