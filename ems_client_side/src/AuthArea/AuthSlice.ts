import {Admin} from "../Models/Admin.ts";
import {configureStore, createSlice, PayloadAction} from "@reduxjs/toolkit";


interface jwtAdmin {

}
interface AuthState {
    admin: Admin;
}


const init: Admin[] = [];


const authSlice = createSlice({
    name: "admins",
    initialState: init,
    reducers: {
        login(state: AuthState, action: PayloadAction<string>) {
            
        },
        logout(state:AuthState, action: PayloadAction<string>) {

        }
    }
})

export {login, logout} = authSlice.actions;
export const authStore = configureStore({
    reducer: authSlice.reducer;
})


