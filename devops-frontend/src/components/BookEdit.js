import { useState } from 'react';
import useBooksContext from '../hooks/use-books-context';

function BookEdit({ book, onSubmit }) {
  const [title, setTitle] = useState(book.title);
  const [imgUrl, setImgUrl] = useState(book.imgUrl);
  const { editBookById } = useBooksContext();

  const handleTitleChange = (event) => {
    setTitle(event.target.value);
  };

  const handleImgUrlChange = (event) => {
    setImgUrl(event.target.value);
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    onSubmit();
    editBookById(book.id, title, imgUrl);
  };

  return (
    <form onSubmit={handleSubmit} className="book-edit">
      <label>Title</label>
      <input className="input" value={title} onChange={handleTitleChange} />
      <input className="input" value={imgUrl} onChange={handleImgUrlChange} />
      <button className="button is-primary">Save</button>
    </form>
  );
}

export default BookEdit;
