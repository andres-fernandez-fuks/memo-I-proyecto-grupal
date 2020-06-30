import React, { Component }  from 'react';
import axios from 'axios';
import {Card, Table} from "react-bootstrap";
import Proyecto from "./Proyecto";

export default class ListadoProyectos extends Component {
    constructor(props) {
        super(props);
        this.state = {
            proyectos : []
        };
    }

    componentDidMount() {
        axios.get('http://localhost:8080/proyectos')
            .then(respuesta => respuesta.data)
            .then((data) => {
                this.setState({proyectos : data})
            });
    }

    render() {
        return (
            <div className={"proyectosDiv"}>
                <Card className={"proyectos-card"}>
                    <Card.Header>Proyectos</Card.Header>
                    <Card.Body>
                        <Table bordered hover striped varient="dark">
                            <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nombre</th>
                                <th>Tipo</th>
                            </tr>
                            </thead>
                            <tbody>
                            {this.state.proyectos.length === 0 ?
                                <tr align="center">
                                    <td colSpan="3">No exite ningun proyecto</td>
                                </tr> :
                                this.state.proyectos.map((proyecto) => (
                                    <tr key={proyecto.id}>
                                        <td>{proyecto.id}</td>
                                        <td>{proyecto.nombre}</td>
                                        <td>{proyecto.tipoDeProyecto}</td>
                                    </tr>
                                ))
                            }
                            </tbody>
                        </Table>
                    </Card.Body>
                    <Card.Footer>
                        <Proyecto/>
                    </Card.Footer>
                </Card>
            </div>
        );
    }
}