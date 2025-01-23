import {Employee} from "../Models/Employee.ts";
import {configureStore, createSlice, PayloadAction} from "@reduxjs/toolkit";


interface EmployeeState{
    employees: Employee[]
}

const init: Employee[] = [];

const employeeSlice = createSlice({
    name: "employees",
    initialState: init,
    reducers: {
        fetchAllEmployees: (state:EmployeeState, action: PayloadAction<Employee[]>) => {
            state.employees = action.payload;
        }
    }
})

export {fetchAllEmployees} = employeeSlice.actions;
export const employeeStore = configureStore({
    reducer: employeeSlice.reducer;
})