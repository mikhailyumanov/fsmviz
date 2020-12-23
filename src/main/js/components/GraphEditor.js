import React from "react";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import {changeGraph} from "../actions/changeGraph";

class GraphEditor extends React.Component {
    render() {
        const {graph, changeGraph} = this.props;

        return (
            <div id="graph-input">
                <textarea id="text-editor"
                          placeholder="vertices"
                          value={graph}
                          form="graph-input-form"
                          onChange={(event) => {
                              changeGraph(event.target.value);
                              document.getElementById('graph-input-form-text')
                                  .setAttribute("value", event.target.value);
                              console.log(event.target.value)
                          }}>
                </textarea>
                <input type="Submit"
                       className="default-button"
                       form="graph-input-form"
                       value="Save"/>
            </div>
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

export const WrappedGraphEditor = connect(putStateToProps, putActionsToProps)(GraphEditor);