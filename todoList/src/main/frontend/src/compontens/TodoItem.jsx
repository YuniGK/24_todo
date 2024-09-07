import React, { useState} from 'react';

const TodoItem = ( { todo, onRemove, onUpdate} ) => {
    let {no, title} = todo;

    const [inputTitle, setInputTitle] = useState('');
    const handleChangeTitle = (e) => {
        setInputTitle(e.target.value);
    }

    return (
        <li>
            <div className="item">
                <label htmlFor={todo.no}></label>
                <span>{todo.title}</span>
            </div>
            <div className="item">
                <button className='btn' onClick={() => onUpdate(no)}>수정</button>
                <button className='btn' onClick={() => onRemove(no)}>삭제</button>
            </div>
        </li>
    )
}

export default TodoItem 