import React, { useState, useEffect } from 'react';
import UploadComponent from './components/UploadComponent';
import TransacoesListComponent from './components/TransacoesListComponent';
import axios from 'axios';



function App() {
  const [transacoes, setTransacoes] = useState([]);
  const [uploadStatus, setUploadStatus] = useState('');

  // Função para listar as transações do backend
  const listarTransacoes = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/transacao/listar');

      if (response.status === 200) {
        const { data } = response;
        setTransacoes(data);
      } else {
        console.error('Erro ao listar transações.');
      }
    } catch (error) {
      console.error('Erro ao fazer a solicitação: ', error);
    }
  };

  useEffect(() => {
    listarTransacoes();
  }, []);

  const handleUpload = async (formData) => {
    try {
      setUploadStatus('Enviando arquivo...');

      // Fazer a solicitação POST para o backend
      const response = await axios.post('http://localhost:8080/api/transacao/upload', formData);
  
      if (response.status === 200) {
        // Os dados normalizados são retornados pelo backend
        //const { transacoes } = response.data;
        //setTransacoes(response.data);
        listarTransacoes();

        setUploadStatus('Arquivo enviado e processado com sucesso.');
      } else {
        setUploadStatus('Erro ao fazer o upload do arquivo.');
        console.error('Erro ao fazer o upload do arquivo.');
      }
    } catch (error) {
      setUploadStatus('Erro ao fazer a solicitação.');
      console.error('Erro ao fazer a solicitação: ', error);
    }
  };

  return (
    <div className="App">
      <h1>Desafio CNAB</h1>
      <UploadComponent onUpload={handleUpload} />
      {/* Mostrar o feedback do upload */}
      {uploadStatus && <p>{uploadStatus}</p>}
      <TransacoesListComponent transacoes={transacoes} />
    </div>
  );
}

export default App;