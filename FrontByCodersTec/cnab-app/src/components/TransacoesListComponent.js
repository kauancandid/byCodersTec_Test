import React from 'react';
import './styles.css'; // Importe o arquivo CSS

function TransacoesListComponent({ transacoes }) {
  return (
    <div>
      <h2>Lista de Transações Importadas</h2>
      <table>
        <thead>
          <tr>
            <th>Tipo</th>
            <th>Data</th>
            <th>Valor</th>
            <th>Cpf</th>
            <th>Cartao</th>
            <th>Hora</th>
            <th>Dono da Loja</th>
            <th>Nome da Loja</th>
            
            
          </tr>
        </thead>
        <tbody>
          {transacoes.map((transacao, index) => (
            <tr key={index}>
              <td>{transacao.tipo}</td>
              <td>{transacao.data}</td>
              <td>{transacao.valor}</td>
              <td>{transacao.cpf}</td>
              <td>{transacao.cartao}</td>
              <td>{transacao.hora}</td>
              <td>{transacao.donoDaLoja}</td>
              <td>{transacao.nomeDaLoja}</td>
              
              
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default TransacoesListComponent;