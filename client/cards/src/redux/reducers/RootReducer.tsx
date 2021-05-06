import {combineReducers} from "redux";
import cardsReducer from "./cardsReducer";

const RootReducer = combineReducers({
    cardReducer: cardsReducer,
});

export default RootReducer;
