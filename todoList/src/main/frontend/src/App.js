/* eslint-disable */

import {useEffect, useState} from "react";
import axios from "axios";

import './App.css';
import TodoBoard from './compontens/TodoBoard';

function App() {
    const [hello, setHello] = useState('');

    /*
    useEffect(() => {
        axios.get('/api/test')
            .then((res) => {
              setHello(res.data);
            })
      }, []);
    */

    useEffect(() => {
        fetch('/api/test')
        .then(res => res.json())
        .then(hello => {
            console.log(hello);
        })
    }, []);
    /* - api test - */

    const [inputValue, setInputValue] = useState('');
    const [todoList, setTodoList] = useState([]);

    const addItem = () => {
        console.log("add > ", inputValue);

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
            <p>백엔드 데이터 : {hello}</p>

            <input value={inputValue} type='text'
                   onChange={(event)=>{
                       setInputValue(event.target.value);
                       console.log("event > ", event.target.value);
                   }}

                   onKeyDown={addEnter}
            />
            <button onClick={addItem}>추가</button>

            <TodoBoard todoList={todoList} onRemove={onRemove} />
        </div>
    );
}

export default App;