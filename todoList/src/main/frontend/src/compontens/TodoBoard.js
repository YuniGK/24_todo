import React from "react";
import TodoItem from "./TodoItem";

function TodoBoard({todoList, onRemove}) {
    console.log("todoBoard ", todoList)

    return(
        <div>
            <h1>Todo List</h1>
        </div>
    )
}

export default TodoBoard