import { ACTION_CHANGE_GRAPH } from "../app";

const initialState = {
    graph: document.getElementById("initial-state-holder").getAttribute("value")
};

export const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case ACTION_CHANGE_GRAPH:
            return {
                ...state,
                graph: action.payload
            };
    }

    return state;
}