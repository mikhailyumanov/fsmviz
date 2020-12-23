import React from "react";
import ReactDOM from "react-dom";
import { createStore } from "redux";
import { Provider } from "react-redux";
import { WrappedGraphEditor } from "./components/GraphEditor"
import { WrappedGraphViewer } from "./components/GraphViewer";
import { rootReducer } from "./reducers/rootReducer";

// constants

export const ACTION_CHANGE_GRAPH = "ACTION_CHANGE_GRAPH";


//======== STORE ========

const store = createStore(rootReducer);


//======== RENDER ALL ========
ReactDOM.render(<Provider store={store}>
    <WrappedGraphViewer/>
</Provider>, document.getElementById("canvas"));
ReactDOM.render(<Provider store={store}>
    <WrappedGraphEditor/>
</Provider>, document.getElementById("graph-editor-holder"));
