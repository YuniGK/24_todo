import React from 'react';
import TodoItem from './TodoItem';

const TodoList = ({ todoList, onRemove, onUpdate }) => {
  return (
    <ul className='todoList'>
      {todoList.map((todo) => (
          <TodoItem
            todo={todo}
            key={todo.no}
            onRemove={onRemove}
            onUpdate={onUpdate}
          />
      ))}
    </ul>
  );
};

export default TodoList;
