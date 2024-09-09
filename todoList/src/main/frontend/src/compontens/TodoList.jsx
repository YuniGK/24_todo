import React from 'react';
import TodoItem from './TodoItem';

const TodoList = ({ todoList, onRemove, onUpdate }) => {
  return (
    <ul className='todoList'>
      {todoList.map((todo, idx) => (
          <TodoItem
            todo={todo}
            key={todo.id}
            onRemove={onRemove}
            onUpdate={onUpdate}
          />
      ))}
    </ul>
  );
};

export default TodoList;
