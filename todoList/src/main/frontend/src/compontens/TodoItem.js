import React from 'react';

function TodoItem({item, idx, onRemove, onUpdate}) {
    console.log("todoItem ", item)

    return(
        <div className="todo-item">
            <p>{item.title}</p>

            <button onClick={() => onUpdate(idx, item)}>수정</button>
            <button onClick={() => onRemove(idx)}>삭제</button>
            <p>{item.createdAt}</p>
        </div>
    )
}

export default TodoItem;