import React, { useState} from 'react';

const TodoItem = ( { todo, onRemove, onUpdate} ) => {
    const [inputTitle, setInputTitle] = useState('');
    const handleChangeTitle = (e) => {
        setInputTitle(e.target.value);
    }

    return (
        <li>
            <div className="item">
                <label htmlFor={todo.id}></label>
                <span>{todo.title}</span>
            </div>
            <div className="item">
                <button className='btn' onClick={() => onUpdate(todo)}>수정</button>
                <button className='btn' onClick={() => onRemove(todo.id)}>삭제</button>
            </div>
        </li>
    )
}

export default TodoItem 