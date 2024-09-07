import React from "react";
import TodoItem from "./TodoItem";

function TodoBoard({todoList, onRemove, onUpdate}) {
    console.log("todoBoard ", todoList)

    return(
        <div>
            <h1>Todo List</h1>

        {todoList.map((item, index) => (
            <TodoItem item={item} key={index} onRemove={onRemove} onUpdate={onUpdate} />
        ))}

        </div>
    )
}

export default TodoBoard