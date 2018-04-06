import Immutable from 'seamless-immutable';
import * as types from './actionTypes';

const initialState = Immutable({
  updateAction: function() {
    return {
      fn: "NULL"
    }
  },
});

export default function reduce(state = initialState, action = {}) {
  switch (action.type) {
    case types.SET_UPDATE_FUNCTION:
      console.log(action.type, action);
      return Immutable.merge(state, { fn: action.updateFunction });
    default:
      return state;
  }
}