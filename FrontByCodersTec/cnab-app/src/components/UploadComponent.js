import React, { useState } from 'react';

function UploadComponent({ onUpload }) {
  const [file, setFile] = useState(null);

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleUpload = () => {
    if (file) {
      const formData = new FormData();
      formData.append('file', file);
      onUpload(formData);
    }
  };

  return (
    <div>
      <h2>Upload do arquivo CNAB</h2>
      <input type="file" accept=".txt" onChange={handleFileChange} />
      <button onClick={handleUpload}>Enviar</button>
    </div>
  );
}

export default UploadComponent;