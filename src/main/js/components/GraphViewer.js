import React from "react";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import {changeGraph} from "../actions/changeGraph";
import ForceGraph2D from "react-force-graph-2d";

function getJson(text) {
    return JSON.parse(text)
}

class GraphViewer extends React.Component {
    render() {
        const {graph, changeGraph} = this.props;

        return (
            <ForceGraph2D
                graphData={getJson(graph)}
                width={window.innerWidth / 2}
                nodeAutoColorBy={d => d["group"]}
                nodeId={"id"}
                nodeLabel={"id"}
                linkDirectionalArrowLength={8}
                linkLabel={link => link["text"]}
                linkCurvature={'curvature'}
            />

        )
    }
}

const putStateToProps = (state) => {
    return {
        graph: state.graph
    };
}

const putActionsToProps = (dispatch) => {
    return {
        changeGraph: bindActionCreators(changeGraph, dispatch)
    };
}

export const WrappedGraphViewer = connect(putStateToProps, putActionsToProps)(GraphViewer);