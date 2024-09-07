/* eslint-disable */

import {useEffect, useState} from "react";
import axios from "axios";

import './App.css';
import TodoBoard from './compontens/TodoBoard';

function App() {
    const [inputValue, setInputValue] = useState('');
    const [todoList, setTodoList] = useState([]);

    useEffect(() => {
        fetch('/todo')
            .then((response) => response.json())
            .then((data) => setTodoList(data))
            .catch((error) => console.log(error));
    }, []);

    const addItem = () => {
        console.log(inputValue);

        setTodoList([...todoList, inputValue])
        setInputValue('');
    };

    const addEnter = e => {
        if (e.key === 'Enter') {
            addItem();
        }
    };

    const onRemove = (id) => {
        setTodoList(todoList.filter((item, idx) => idx !== id));
    }

    return (
        <div className="App">
            <input value={inputValue} type='text'
                   onChange={(event)=>{
                       setInputValue(event.target.value);
                   }}

                   onKeyDown={addEnter}
            />
            <button onClick={addItem}>추가</button>

            <TodoBoard todoList={todoList} onRemove={onRemove} />
        </div>
    );
}

export default App;