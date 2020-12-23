import { ACTION_CHANGE_GRAPH } from "../app"

export const changeGraph = (newGraph) => {
    return {
        type: ACTION_CHANGE_GRAPH,
        payload: newGraph
    };
};