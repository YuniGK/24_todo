import React, { useState, useEffect } from 'react';
import TodoHeader from './TodoHeader';
import TodoInput from "./TodoInput";
import TodoList from "./TodoList";

const TodoContainer = () => {
  const [todoList, setTodoList] = useState([]);
  const [input, setInput] = useState('');

  /* 리스트 조회 */
  useEffect(() => {
    fetch('/todo')
      .then((response) => response.json())
      .then((data) => setTodoList(data))
      .catch((error) => console.log(error));
  }, []);

  const onChange = (e) => {
    setInput(e.target.value);
  };

  /* insert */
  const onSubmit = async (e) => {
    e.preventDefault();

    // POST request
    const data = {
      title: input,
      deleted : "저장"
    };

    const init = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    };

    try {
      const response = await fetch('/todo/insert', init);
      const newTodo = await response.json();
      const updatedList = [newTodo, ...todoList]
      setTodoList( updatedList );
    } catch (error) {
      console.log(error);
    }

    setInput('');
  };

  /* 삭제 */
  const onRemove = async (no) => {
    console.log(no);

    const init = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    };

    console.log(no)

    try {
      const response = await fetch(`/todo/deleted/${no}`, init);
      console.log(response);
    } catch (error) {
      console.log(error);
    }

    setTodoList( (todoList) => todoList.filter((todo) => todo.no !== no) )
  };

  /* 수정 */
  const onUpdate = async (no) => {
    /*
    const init = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
    };

    try {
      const response = await fetch(`/todo/update/${no}`, init);
      console.log(response);
    } catch (error) {
      console.log(error);
    }
    */
  };

  return (
    <div className='container'>
      <TodoHeader />
      <TodoInput input={input} onChange={onChange} onSubmit={onSubmit} />
      <TodoList todoList={todoList} onRemove={onRemove} onUpdate={onUpdate} />
    </div>
  );
};

export default TodoContainer;
