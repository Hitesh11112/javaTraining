import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  data: null,
  loading: false,
  error: null,
};

const userSlice = createSlice({
  name: "user",
  initialState,
  reducers: {
    loadUserStart: (state) => {
      state.loading = true;
      state.error = null;
    },

    loadUser: (state, action) => {
      state.loading = false;
      state.data = action.payload;
      state.error = null;
    },

    loadUserFailure: (state, action) => {
      state.loading = false;
      state.error = action.payload;
    },
  },
});

export const {
  loadUser,
  loadUserStart,
  loadUserFailure,
} = userSlice.actions;

export default userSlice.reducer;

// Fake API Call
const getUserData = () => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      const success = true;

      if (success) {
        resolve({
          id: 1,
          name: "Hitesh",
          desg: "GET",
        });
      } else {
        reject("Failed to fetch user");
      }
    }, 2000);
  });
};

// Thunk
export const fetchUser = () => async (dispatch) => {
  dispatch(loadUserStart());

  try {
    const user = await getUserData();
    dispatch(loadUser(user));
  } catch (error) {
    dispatch(loadUserFailure(error));
  }
};