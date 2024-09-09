import React, { useState, useRef} from 'react';

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {faTrashCan, faPenToSquare } from "@fortawesome/free-regular-svg-icons";
import {faCheck, faXmark} from "@fortawesome/free-solid-svg-icons";

const TodoItem = ( { todo, onRemove, onUpdate} ) => {
    const editedText = useRef(null);

    const [isEditClicked, setIsEditClicked] = useState(false);
    const [updatedText, setUpdatedText] = useState('');

    const submitEditedContent = () => {
        if (updatedText === '') {
            setIsEditClicked(false);
            return;
        }

        setUpdatedText('');
        setIsEditClicked(false);

        onUpdate(updatedText, todo.id);
    }

    const openEdit = (id) => {
        console.log(JSON.stringify(editedText)+" "+id);
        setIsEditClicked(true);
        //editedText.current.focus();
    }

    const cancelEdit = () => {
        setUpdatedText('');
        setIsEditClicked(false);
    }

    return (
        <li>
            <div className="item">
                <label htmlFor={todo.id}></label>

                {isEditClicked ? (
                        <div>
                            <input
                                value={updatedText}
                                onChange={(e) => setUpdatedText(e.target.value)}
                                ref={editedText}
                            />
                        </div>
                    ) : (
                    <div>
                        {todo.title}
                    </div>
                    )
                }
            </div>

            <div className="item">
                {isEditClicked ? (
                        <div>
                            <button onClick={submitEditedContent}>
                                <FontAwesomeIcon icon={faCheck} size="2x" color="white"/>
                            </button>
                            <button onClick={cancelEdit}>
                                <FontAwesomeIcon icon={faXmark} size="2x" color="white"/>
                            </button>
                        </div>
                    ) : (
                    <button className='btn' onClick={() => openEdit(todo.id)}>
                        {/* 수정 */}
                        <FontAwesomeIcon icon={faPenToSquare} size="2x" color="white"/>
                    </button>
                    )
                }

                <button className='btn' onClick={() => onRemove(todo.id)}>
                    {/* 삭제 */}
                    <FontAwesomeIcon icon={faTrashCan} size="2x" color="white"/>
                </button>
            </div>
        </li>
    )
}

export default TodoItem 