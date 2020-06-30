import React, { Component } from 'react';
import { withRouter } from 'react-router';
import ListadoProyectos from "../component/ModuloProyectos/ListadoProyectos";

class ProyectosScreen extends Component {

    render() {
        return (
            <div className="proyectos-screen-div">
                <ListadoProyectos/>
            </div>
        )
    }

}

export default withRouter(ProyectosScreen);