import * as types from "./actionTypes";

export const setCards = cards => ({
    type: types.SET_CARDS,
    payload: cards
});
