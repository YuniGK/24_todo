import React from "react";
import TodoItem from "./TodoItem";

function TodoBoard({todoList, onRemove}) {
    console.log("todoBoard ", todoList)

    return(
        <div>
            <h1>Todo List</h1>

        {todoList.map((item, index) => (
            <TodoItem item={item} key={index} onRemove={onRemove} />
        ))}

        </div>
    )
}

export default TodoBoard