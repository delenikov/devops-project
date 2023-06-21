import { useState } from 'react';
import useBooksContext from '../hooks/use-books-context';

function BookCreate() {
  const [title, setTitle] = useState('');
  const [imgUrl, setImgUrl] = useState('');
  const { createBook } = useBooksContext();

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleImgUrlChange = (event) => {
    setImgUrl(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    createBook(title, imgUrl);
    setTitle('');
    setImgUrl('')
  };

  return (
    <div className="book-create">
      <h3>Add a Book</h3>
      <form onSubmit={handleSubmit}>
        <label>Title</label>
        <input className="input" value={title} onChange={handleTitleChange} />
        <label>Image url</label>
        <input className="input" value={imgUrl} onChange={handleImgUrlChange} />
        <button className="button">Create!</button>
      </form>
    </div>
  );
}

export default BookCreate;
