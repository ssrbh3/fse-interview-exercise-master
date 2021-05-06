import * as types from "../actions/actionTypes";
export interface DefaultStateI {
    cards: []
}
 const defaultState: DefaultStateI = {
    cards: []
}
type Action = {type:"SET_CARDS", payload:[] }
const cardsReducer = (state : DefaultStateI = defaultState , action:Action) : DefaultStateI => {
    switch (action.type) {
        case types.SET_CARDS:
            state = {
                ...state,
                cards: {
                    ...action.payload
                }
            };
            break;
        default:
    }
    return state;
}
export default cardsReducer;
